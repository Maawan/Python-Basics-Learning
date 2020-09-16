package com.hayatsoftwares.www.python;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jorgecastilloprz.progressarc.ProgressArcView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class learn_lectures extends AppCompatActivity {
    private WebView webview;
    AnimationDrawable animationDrawable;
    private ProgressBar progressBar;
    RelativeLayout loading_error_layout;
    Button retry;
    private CardView pageNoView;
    private TextView pageNotext;
    private RelativeLayout loading_layout;
    private String[] webpage_urls;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    Bundle extras;
    private int position;
    int i=0;
    private String identifier;
    private int cLass;
    private FloatingActionButton fab,fab_back;

    @Override
    protected void onStop() {
      //  Toast.makeText(this, "Stop Called", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onStart() {
       // Toast.makeText(this, "On Start", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onPostResume() {
       // Toast.makeText(this, "On Post Resume", Toast.LENGTH_SHORT).show();
        super.onPostResume();
    }

    @Override
    protected void onResume() {
       // Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_learn_lectures);
        pageNotext = (TextView)findViewById(R.id.page_text);
        pageNoView = (CardView)findViewById(R.id.pageNocard);
        pageNoView.setVisibility(View.GONE);


        getSupportActionBar().hide();
        Declare();
        Loading_work();
        user = firebaseAuth.getCurrentUser();



        extras = getIntent().getExtras();
        if (extras != null) {

            webpage_urls = extras.getStringArray("urls");
            identifier = extras.getString("identifier");
            position = extras.getInt("position");
            cLass = extras.getInt("cLass");

            //Toast.makeText(this, "Length of Array is "+ webpage_urls.length, Toast.LENGTH_SHORT).show();
            webview.loadUrl(webpage_urls[i]);
            loading_layout.setVisibility(View.VISIBLE);
            animationDrawable.start();

        }
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                pageNoView.setVisibility(View.GONE);
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                      loading_error_layout.setVisibility(View.VISIBLE);
                      pageNoView.setVisibility(View.GONE);

            }

            @SuppressLint("RestrictedApi")
            public void onPageFinished(WebView view, String url) {
              // progressBar.setVisibility(View.GONE);
               loading_layout.setVisibility(View.GONE);
               if(identifier.equals("error")  || identifier.equals("do")){
                   pageNoView.setVisibility(View.VISIBLE);
                   pageNotext.setText("Page "+(i+1)+" out of "+webpage_urls.length);
               }

               fab.setVisibility(View.VISIBLE);
               if(i!=0)
               {fab_back.setVisibility(View.VISIBLE);}

                if(user!=null)
                {DatabaseReference myRef = firebaseDatabase.getReference("Users_Database/"+user.getUid()+"/"+identifier+"/"+cLass+"/"+(position+1)+"/"+i);
                    myRef.setValue(1);}

            }
        });

         fab.setOnClickListener(new View.OnClickListener() {
             @SuppressLint("RestrictedApi")
             @Override
             public void onClick(View v) {
                 i++;
                 pageNoView.setVisibility(View.GONE);

                 loading_layout.setVisibility(View.VISIBLE);
             int temp=webpage_urls.length;
             if(i==temp-1){
                 fab.setImageResource(R.drawable.ic_check_black_24dp);
                 fab.setVisibility(View.GONE);
                  webview.loadUrl(webpage_urls[i]);

             }
             else if(i==temp){

                 onBackPressed();
             }
             else {
                 webview.clearFormData();
                 webview.loadUrl(webpage_urls[i]);
                 fab.setVisibility(View.GONE);
                // progressBar.setVisibility(View.VISIBLE);
                 loading_layout.setVisibility(View.VISIBLE);
             }
             }
         });
         fab_back.setOnClickListener(new View.OnClickListener() {
             @SuppressLint("RestrictedApi")
             @Override
             public void onClick(View v) {
                 fab.setVisibility(View.GONE);
                 fab_back.setVisibility(View.GONE);
                 i--;
                 webview.loadUrl(webpage_urls[i]);
                 pageNoView.setVisibility(View.GONE);
                 loading_layout.setVisibility(View.VISIBLE);
             }
         });
         retry.setOnClickListener(new View.OnClickListener() {
             @SuppressLint("RestrictedApi")
             @Override
             public void onClick(View v) {
                 if(isNetworkAvailable()) {
                     webview.loadUrl(webpage_urls[i]);
                     fab.setVisibility(View.GONE);
                     loading_layout.setVisibility(View.VISIBLE);
                     loading_error_layout.setVisibility(View.GONE);
                 }else {
                     Toast.makeText(learn_lectures.this, "Your Internet Connection is not Active", Toast.LENGTH_SHORT).show();
                 }

             }
         });


    }
    @SuppressLint("RestrictedApi")
    private void Declare(){
        webview=(WebView)findViewById(R.id.webview);
        firebaseAuth = FirebaseAuth.getInstance();
        loading_error_layout = (RelativeLayout)findViewById(R.id.error_loading_page);
        webview.getSettings().setJavaScriptEnabled(true);
        firebaseDatabase = FirebaseDatabase.getInstance();
        retry = (Button)findViewById(R.id.retry);
        progressBar = (ProgressBar)findViewById(R.id.progress);
        progressBar.setVisibility(View.GONE);
        fab = (FloatingActionButton)findViewById(R.id.floating_action_button);
        fab_back = (FloatingActionButton)findViewById(R.id.floating_action_button2);
        fab.setVisibility(View.GONE);
        fab_back.setVisibility(View.GONE);
    }
    private void Loading_work(){
        loading_layout = (RelativeLayout)findViewById(R.id.loading_layout);
        ImageView imageView = (ImageView)findViewById(R.id.anime_imageView);
        animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
