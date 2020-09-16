package com.hayatsoftwares.www.python;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;


import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class learn_menu_activity extends AppCompatActivity {
    private TextView status_title;
    private ViewPager mViewPager;
    Button back;
    private CardPageAdapter_2 mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_learn_menu_activity);

        setTitle("Learn Section");
        getSupportActionBar().hide();
        status_title=(TextView)findViewById(R.id.learn_title_logo);
        text_font_formatter(status_title);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_learn);


        mCardAdapter = new CardPageAdapter_2();
        mCardAdapter.addCardItem(new CardItem(R.string.title_learn_1, R.string.learn_desc_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_learn_2, R.string.learn_desc_2));
        mCardAdapter.addCardItem(new CardItem(R.string.title_learn_3, R.string.learn_desc_3));
        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(learn_menu_activity.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
    public void text_font_formatter(TextView textView)
    {
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/adventprobold.ttf");
        textView.setTypeface(custom_font);

    }
}
