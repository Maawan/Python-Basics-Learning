package com.hayatsoftwares.www.python;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class User_Profile extends AppCompatActivity {
    private static final String SHARED_PREF ="sharedPref";
    private TextView username,user_mail,text;
    String value,MAIL,url;
    ImageView profile_image;
    CircularProgressBar circularProgressBar,circularProgressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user__profile);
        //getSupportActionBar().hide();
        setTitle("Your Profile");

        username=(TextView)findViewById(R.id.username);
        profile_image=(ImageView)findViewById(R.id.profile_image);
        user_mail=(TextView)findViewById(R.id.user_mail);
        text=(TextView)findViewById(R.id.progress_report_text);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/adventprobold.ttf");
        username.setTypeface(custom_font);
        user_mail.setTypeface(custom_font);
        text.setTypeface(custom_font);
        circularProgressBar=(CircularProgressBar)findViewById(R.id.circularProgressBar1);
        circularProgressBar2=(CircularProgressBar)findViewById(R.id.circularProgressBar2);
        refresh(57,82);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Bundle bundle = new Bundle();
            value = extras.getString("USERNAME");
            MAIL = extras.getString("MAIL");
            url = extras.getString("IMAGE");
            // Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
            Glide.with(this).load(url).fitCenter().into(profile_image);
            username.setText(value);
            user_mail.setText(MAIL);
        }



    }
    private void refresh(int a,int b)
    {    long temp1=3000;

        circularProgressBar2.setProgressWithAnimation(a,temp1);
        circularProgressBar.setProgressWithAnimation(b,temp1);
        circularProgressBar.setProgressBarColorStart(Color.BLUE);
        circularProgressBar.setProgressBarColorEnd(Color.parseColor("#64B5F6"));
        circularProgressBar2.setProgressBarColorStart(Color.BLUE);
        circularProgressBar2.setProgressBarColorEnd(Color.parseColor("#64B5F6"));

    }
//    public void loaddata_pref() {
//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
//        value = sharedPreferences.getString("USERNAME", "");
//        MAIL = sharedPreferences.getString("MAIL_ID", "");
//        url = sharedPreferences.getString("URL", "");
//    }

}
