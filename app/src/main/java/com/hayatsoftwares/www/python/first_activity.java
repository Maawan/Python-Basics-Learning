package com.hayatsoftwares.www.python;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;


import android.os.Bundle;

import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class first_activity extends AppCompatActivity {
    TextView textlogo,hayat,hayat1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first_activity);
        hayat=(TextView)findViewById(R.id.aa);
        hayat1=(TextView)findViewById(R.id.bb);
        getSupportActionBar().hide();
        textlogo=(TextView)findViewById(R.id.text_logo);
        Typeface custom_font2 = Typeface.createFromAsset(getAssets(), "fonts/adventpro-light.ttf");
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/adventprobold.ttf");
       hayat.setTypeface(custom_font2);
        hayat1.setTypeface(custom_font);
        textlogo.setTypeface(custom_font);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(first_activity.this,Welcome.class);
                startActivity(intent);
                finish();
            }
        },1900);

    }
}
