package com.hayatsoftwares.www.python;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;


//import android.support.v7.widget.CardView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CardPageAdapter_2 extends PagerAdapter implements CardAdapter {
    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;
    private ImageView card_image;
    private Button btn_card;
    private TextView title,desc;
   // Button card_button;
   // private ImageView image;
    private Context context;

    public CardPageAdapter_2() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }



    @Override
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

    @NonNull
    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter_2, container, false);
        container.addView(view);
        bind(mData.get(position), view);

        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }
        context=container.getContext();
        title=(TextView)view.findViewById(R.id.titleTextView);
        btn_card=(Button)view.findViewById(R.id.button_card);
        btn_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0)
                {
//                    Intent intent=new Intent(context,python_concepts_all.class);
//                    Pair[] pairs=new Pair[1];
//                    pairs[0]=new Pair<View,String>(title,"title_python");
//                    ActivityOptions options = null;
//                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                        options = ActivityOptions.makeSceneTransitionAnimation((Activity) context,pairs);
//                    }
//                    context.startActivity(intent,options.toBundle());
//                    //context.startActivity(intent);
                    context.startActivity(new Intent(context,python_concepts_all.class));
                }
                else if(position == 1){
                    context.startActivity(new Intent(context,errors_finding.class));
                }
                else if(position==2){
                    context.startActivity(new Intent(context,do_menu.class));
                }
            }
        });

        card_image=(ImageView)view.findViewById(R.id.card_image1);
        if(position==1)
        {
            card_image.setImageResource(R.drawable.puzzle);
        }
        else if(position==2)
        {
            card_image.setImageResource(R.drawable.output_final_1);
        }
        desc=(TextView)view.findViewById(R.id.contentTextView);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(desc,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    @Override
    public boolean isViewFromObject(View view,Object object) {
        return view == object;
    }
    private void bind(CardItem item, View view) {
        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        TextView contentTextView = (TextView) view.findViewById(R.id.contentTextView);
        titleTextView.setText(item.getTitle());
        contentTextView.setText(item.getText());
    }
}
