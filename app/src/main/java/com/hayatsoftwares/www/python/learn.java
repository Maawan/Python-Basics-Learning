package com.hayatsoftwares.www.python;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.os.Bundle;
//import android.support.v7.widget.CardView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class learn extends AppCompatActivity {
    private WebView web;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private FirebaseDatabase firebaseDatabase;
    private FloatingActionButton floatingActionButton;
    private String url;
    private int cardNo;
    private int cLass;
    private int a=0;
    private RelativeLayout connection;
    private ProgressBar progressBar;
    private int position;
    private CardView Try;

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        getSupportActionBar().hide();
        initialise_firebase();
        connection = (RelativeLayout) findViewById(R.id.layout_connection);
        if(isNetworkAvailable()==false){
            connection.setVisibility(View.VISIBLE);
        }
        floatingActionButton = (FloatingActionButton)findViewById(R.id.floating_action_button);

        Intent intent = getIntent();
        if (intent != null) {
            url = intent.getStringExtra("url");
            position = intent.getIntExtra("identifier",0);
            cardNo = intent.getIntExtra("cardNo",1);
            cLass = intent.getIntExtra("cLass",11);
            Try = (CardView) findViewById(R.id.try_again);
            connection = (RelativeLayout) findViewById(R.id.layout_connection);
            //error_connection=(RelativeLayout)findViewById(R.id.error_connection);
            progressBar = (ProgressBar) findViewById(R.id.progress_webview);

            web = (WebView) findViewById(R.id.web);
            web.getSettings().setJavaScriptEnabled(true);
            web.loadUrl(url);
            web.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    DatabaseReference ref = firebaseDatabase.getReference("Users_Database/"+user.getUid()+"/Programs/"+cLass+"/"+cardNo+"/"+position);
                    ref.setValue(1);
                    floatingActionButton.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);


                }

            });
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });


        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private void initialise_firebase(){
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
    }


}
