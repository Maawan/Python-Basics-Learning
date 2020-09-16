package com.hayatsoftwares.www.python;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;

//import android.support.v7.widget.CardView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;
    private TextView title,desc;
    private Button card_button;
    private ImageView image;
    private Context context;

    public CardPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        context=container.getContext();
        desc=(TextView)view.findViewById(R.id.contentTextView);

        image=(ImageView)view.findViewById(R.id.card_image1);
        if(position==1)
        {
            image.setImageResource(R.drawable.program_3);
        }

        card_button=(Button)view.findViewById(R.id.button_card);
        card_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==1)
                {
                    Intent intent=new Intent(context,Program_list_by_class.class);
                    context.startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(context,learn_menu_activity.class);
                    context.startActivity(intent);
                }
            }
        });
        if(position==0)
        {
            card_button.setText("Dive Into It ");
        }
        else
        {
            card_button.setText("Enter Into It");
        }

        title=(TextView)view.findViewById(R.id.titleTextView);
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "fonts/adventprobold.ttf");
        title.setTypeface(custom_font);

        TextViewCompat.setAutoSizeTextTypeWithDefaults(desc,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
       view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(position==1)
               Toast.makeText(context, "You tapped on Programs Segment", Toast.LENGTH_SHORT).show();

           }
       });



        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(CardItem item, View view) {
        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        TextView contentTextView = (TextView) view.findViewById(R.id.contentTextView);
        titleTextView.setText(item.getTitle());
        contentTextView.setText(item.getText());
    }


}
