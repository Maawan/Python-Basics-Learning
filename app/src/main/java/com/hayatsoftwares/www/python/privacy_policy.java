package com.hayatsoftwares.www.python;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class privacy_policy extends AppCompatActivity {
    private WebView web_privacy;
    private RelativeLayout no_connection_privacy;
    private CardView retry;
    private ProgressBar progressBar_privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        setTitle("Privacy Policy");
        web_privacy=(WebView)findViewById(R.id.web_privacy);
        retry=(CardView) findViewById(R.id.try_again_privacy);
        no_connection_privacy=(RelativeLayout)findViewById(R.id.privacy_no_connection_layout);
         progressBar_privacy=(ProgressBar)findViewById(R.id.progress_privacy);
        web_privacy.loadUrl("https://learn-c-4e4af.firebaseapp.com/privacy_python.html");
        if( isNetworkAvailable())
        {no_connection_privacy.setVisibility(View.GONE);
         }
        else {no_connection_privacy.setVisibility(View.VISIBLE);}
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNetworkAvailable())
                {web_privacy.loadUrl("https://learn-c-4e4af.firebaseapp.com/privacy_python.html");
                no_connection_privacy.setVisibility(View.GONE);}

                else{
                    Toast.makeText(privacy_policy.this, "Your Network is not Active", Toast.LENGTH_LONG).show();
                }
            }
        });
        web_privacy.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
               progressBar_privacy.setVisibility(View.GONE);
            }
        });


    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
