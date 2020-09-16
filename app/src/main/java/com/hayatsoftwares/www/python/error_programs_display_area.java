package com.hayatsoftwares.www.python;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.FoldingCube;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.sql.Array;

import static android.view.View.GONE;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class error_programs_display_area extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private WebView webview;
    private CardView card_no;
    private FloatingActionButton forwardFAB, backFAB;
    private ProgressBar progressBar;
    private TextView page_no;
    private int identifier;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseUser user;
    private int first, second, third;
    private String[] webpage_urls;
    private String option;
    private int CLASS, module_no, j;
    private RelativeLayout loading;
    int i = 0;
    private AdView mAdView;
    private AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_programs_display_area);
        getSupportActionBar().hide();
        progressbarinit();


        loading = (RelativeLayout)findViewById(R.id.loading_anime);
        loading.setVisibility(View.VISIBLE);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        user = firebaseAuth.getCurrentUser();
        forwardFAB = (FloatingActionButton) findViewById(R.id.floating_action_button);
        card_no = (CardView) findViewById(R.id.page_card);
        card_no.setVisibility(GONE);
        backFAB = (FloatingActionButton) findViewById(R.id.floating_action_button2);
        page_no = (TextView) findViewById(R.id.page_text);
        webview = (WebView) findViewById(R.id.web);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        final WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Intent intent = getIntent();
        if (intent != null) {
            identifier = intent.getIntExtra("identifier", 0);
            int temp = identifier;
            third = temp % 10;
            temp = temp / 10;
            second = temp % 10;
            temp = temp / 10;
            first = temp % 10;
            if (first == 1) {
                option = "error";
            } else if (first == 2) {
                option = "do";
            }

            if (second == 1) {
                CLASS = 11;
            } else if (second == 2) {
                CLASS = 12;
            }
            module_no = third;
            makearray();
        }
//        for( j=0;j<webpage_urls.length-1;j++){
//            DatabaseReference ref = firebaseDatabase.getReference("Users_Database/"+user.getUid()+"/"+option+"/"+CLASS+"/"+module_no+"/"+j);
//            ref.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    // This method is called once with the initial value and again
//                    // whenever data at this location is updated.
//                    if (dataSnapshot.getValue(Long.class) != null) {
//                        Long value = dataSnapshot.getValue(Long.class);
//                        //Log.d(TAG, "Value is: " + value);
//                        // Toast.makeText(getActivity(), "Value is " + value, Toast.LENGTH_SHORT).show();
//                        if (value == 1) {
//                            i = j;
//
//                        }
//                    }
//                }
//
//                @Override
//                public void onCancelled(DatabaseError error) {
//                    // Failed to read value
//                    Log.w(TAG, "Failed to read value.", error.toException());
//                }
//            });
//        }
        webview.loadUrl(webpage_urls[i]);
        progressBar.setVisibility(View.VISIBLE);
        forwardFAB.setVisibility(GONE);
        backFAB.setVisibility(GONE);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                loading.setVisibility(GONE);
                progressBar.setVisibility(GONE);
                if (user != null) {
                    DatabaseReference databaseReference = firebaseDatabase.getReference("Users_Database/" + user.getUid() + "/" + option + "/" + CLASS + "/" + module_no + "/" + i);
                    databaseReference.setValue(1);
                }
                forwardFAB.setVisibility(View.VISIBLE);
                if (i != 0) {
                    backFAB.setVisibility(View.VISIBLE);
                }
                card_no.setVisibility(View.VISIBLE);
                page_no.setText("Page " + (i + 1) + " Out of " + webpage_urls.length);
                if (i == (webpage_urls.length - 1)) {
                    forwardFAB.setImageResource(R.drawable.ic_check_black_24dp);
                }
            }
        });
        forwardFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i !=(webpage_urls.length)){
                    forwardFAB.setImageResource(R.drawable.ic_arrow_forward_black_24dp);
                }
                loading.setVisibility(View.VISIBLE);
                card_no.setVisibility(GONE);
                int temp = webpage_urls.length;
                if (i == temp - 1) {
                    onBackPressed();
                } else {
                    i++;
                    webview.loadUrl(webpage_urls[i]);
                    progressBar.setVisibility(View.VISIBLE);
                    forwardFAB.setVisibility(GONE);
                    backFAB.setVisibility(GONE);
                }
            }
        });
        backFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i !=(webpage_urls.length)){
                    forwardFAB.setImageResource(R.drawable.ic_arrow_forward_black_24dp);
                }
                loading.setVisibility(View.VISIBLE);
                card_no.setVisibility(GONE);
                i--;
                webview.loadUrl(webpage_urls[i]);
                progressBar.setVisibility(View.VISIBLE);
                forwardFAB.setVisibility(GONE);
                backFAB.setVisibility(GONE);
            }
        });
        addinit();
        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        DatabaseReference myRef = firebaseDatabase.getReference("AdValidator");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot.getValue(Long.class) != null) {
                    Long value = dataSnapshot.getValue(Long.class);

                    if (value == 1) {
                        mAdView.loadAd(adRequest);
                    }
                } else {
                    mAdView.setVisibility(GONE);

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



    }

    private void makearray() {
        if (identifier == 111) {
            webpage_urls = new String[]{"https://pythom-17c93.web.app/python_fundamentals/error/1.html", "https://pythom-17c93.web.app/python_fundamentals/error/2.html"
                    , "https://pythom-17c93.web.app/python_fundamentals/error/3.html", "https://pythom-17c93.web.app/python_fundamentals/error/4.html", "https://pythom-17c93.web.app/python_fundamentals/error/5.html",
                    "https://pythom-17c93.web.app/python_fundamentals/error/6.html", "https://pythom-17c93.web.app/python_fundamentals/error/7.html", "https://pythom-17c93.web.app/python_fundamentals/error/8.html"
                    , "https://pythom-17c93.web.app/python_fundamentals/error/9.html", "https://pythom-17c93.web.app/python_fundamentals/error/10.html", "https://pythom-17c93.web.app/python_fundamentals/error/11.html",
                    "https://pythom-17c93.web.app/python_fundamentals/error/12.html", "https://pythom-17c93.web.app/python_fundamentals/error/13.html", "https://pythom-17c93.web.app/python_fundamentals/error/14.html",
                    "https://pythom-17c93.web.app/python_fundamentals/error/15.html", "https://pythom-17c93.web.app/python_fundamentals/error/16.html",
                    "https://pythom-17c93.web.app/python_fundamentals/error/17.html", "https://pythom-17c93.web.app/python_fundamentals/error/18.html"};
        } else if (identifier == 211) {
            webpage_urls = new String[]{"https://pythom-17c93.web.app/python_fundamentals/do/1.html", "https://pythom-17c93.web.app/python_fundamentals/do/2.html",
                    "https://pythom-17c93.web.app/python_fundamentals/do/3.html", "https://pythom-17c93.web.app/python_fundamentals/do/4.html", "https://pythom-17c93.web.app/python_fundamentals/do/5.html"
                    , "https://pythom-17c93.web.app/python_fundamentals/do/6.html", "https://pythom-17c93.web.app/python_fundamentals/do/7.html", "https://pythom-17c93.web.app/python_fundamentals/do/8.html", "https://pythom-17c93.web.app/python_fundamentals/do/9.html"
                    , "https://pythom-17c93.web.app/python_fundamentals/do/10.html", "https://pythom-17c93.web.app/python_fundamentals/do/11.html", "https://pythom-17c93.web.app/python_fundamentals/do/12.html", "https://pythom-17c93.web.app/python_fundamentals/do/13.html"};
        } else if (identifier == 212) {
            webpage_urls = new String[]{"https://pythom-17c93.web.app/data_handling/do/1.html", "https://pythom-17c93.web.app/data_handling/do/2.html", "https://pythom-17c93.web.app/data_handling/do/3.html"
                    , "https://pythom-17c93.web.app/data_handling/do/4.html", "https://pythom-17c93.web.app/data_handling/do/5.html", "https://pythom-17c93.web.app/data_handling/do/6.html", "https://pythom-17c93.web.app/data_handling/do/7.html",
                    "https://pythom-17c93.web.app/data_handling/do/8.html", "https://pythom-17c93.web.app/data_handling/do/9.html", "https://pythom-17c93.web.app/data_handling/do/10.html", "https://pythom-17c93.web.app/data_handling/do/11.html",
                    "https://pythom-17c93.web.app/data_handling/do/12.html", "https://pythom-17c93.web.app/data_handling/do/13.html", "https://pythom-17c93.web.app/data_handling/do/14.html", "https://pythom-17c93.web.app/data_handling/do/15.html", "https://pythom-17c93.web.app/data_handling/do/16.html",
                    "https://pythom-17c93.web.app/data_handling/do/17.html", "https://pythom-17c93.web.app/data_handling/do/18.html", "https://pythom-17c93.web.app/data_handling/do/19.html", "https://pythom-17c93.web.app/data_handling/do/20.html",
                    "https://pythom-17c93.web.app/data_handling/do/21.html"};
        } else if (identifier == 112) {
            webpage_urls = new String[]{"https://pythom-17c93.web.app/data_handling/error/1.html", "https://pythom-17c93.web.app/data_handling/error/2.html"};
        }
        else if(identifier == 113){
            webpage_urls = new String[]{"https://pythom-17c93.web.app/conditional/error/1.html","https://pythom-17c93.web.app/conditional/error/2.html","https://pythom-17c93.web.app/conditional/error/3.html","https://pythom-17c93.web.app/conditional/error/4.html","https://pythom-17c93.web.app/conditional/error/5.html"};
        }
        else if(identifier == 213){
            webpage_urls = new String[]{"https://pythom-17c93.web.app/conditional/do/1.html","https://pythom-17c93.web.app/conditional/do/2.html","https://pythom-17c93.web.app/conditional/do/3.html","https://pythom-17c93.web.app/conditional/do/4.html"
            ,"https://pythom-17c93.web.app/conditional/do/5.html","https://pythom-17c93.web.app/conditional/do/6.html","https://pythom-17c93.web.app/conditional/do/7.html","https://pythom-17c93.web.app/conditional/do/8.html","https://pythom-17c93.web.app/conditional/do/9.html","https://pythom-17c93.web.app/conditional/do/10.html"
            ,"https://pythom-17c93.web.app/conditional/do/11.html","https://pythom-17c93.web.app/conditional/do/12.html","https://pythom-17c93.web.app/conditional/do/13.html"};
        }
        else if(identifier==114){
            webpage_urls = new String[]{"https://pythom-17c93.web.app/string/error/1.html","https://pythom-17c93.web.app/string/error/2.html","https://pythom-17c93.web.app/string/error/3.html"};
        }
        else if(identifier ==214){
            webpage_urls = new String[]{"https://pythom-17c93.web.app/string/do/1.html","https://pythom-17c93.web.app/string/do/2.html","https://pythom-17c93.web.app/string/do/3.html","https://pythom-17c93.web.app/string/do/4.html",
            "https://pythom-17c93.web.app/string/do/5.html","https://pythom-17c93.web.app/string/do/6.html","https://pythom-17c93.web.app/string/do/7.html","https://pythom-17c93.web.app/string/do/8.html"};
        }
        else if(identifier ==115){
            webpage_urls = new String[]{"https://pythom-17c93.web.app/list_manupulation/error/1.html","https://pythom-17c93.web.app/list_manupulation/error/2.html","https://pythom-17c93.web.app/list_manupulation/error/3.html"};
        }else if(identifier == 116){
            webpage_urls = new String[]{"https://pythom-17c93.web.app/tuple/error/1.html","https://pythom-17c93.web.app/tuple/error/2.html","https://pythom-17c93.web.app/tuple/error/3.html"};
        }
        else if(identifier == 117){
            webpage_urls = new String[]{"https://pythom-17c93.web.app/dict/error/1.html"};
        }
        else if(identifier ==215){
            webpage_urls = new String[]{"https://pythom-17c93.web.app/list_manupulation/do/1.html","https://pythom-17c93.web.app/list_manupulation/do/2.html","https://pythom-17c93.web.app/list_manupulation/do/3.html",
            "https://pythom-17c93.web.app/list_manupulation/do/4.html","https://pythom-17c93.web.app/list_manupulation/do/5.html","https://pythom-17c93.web.app/list_manupulation/do/6.html","https://pythom-17c93.web.app/list_manupulation/do/7.html","https://pythom-17c93.web.app/list_manupulation/do/8.html"};
        }else if(identifier == 216){
            webpage_urls = new String[]{"https://pythom-17c93.web.app/tuple/do/1.html","https://pythom-17c93.web.app/tuple/do/2.html","https://pythom-17c93.web.app/tuple/do/3.html","https://pythom-17c93.web.app/tuple/do/4.html","https://pythom-17c93.web.app/tuple/do/5.html"};
        }else if(identifier ==217){
            webpage_urls = new String[]{"https://pythom-17c93.web.app/dict/do/1.html","https://pythom-17c93.web.app/dict/do/2.html","https://pythom-17c93.web.app/dict/do/3.html","https://pythom-17c93.web.app/dict/do/4.html","https://pythom-17c93.web.app/dict/do/5.html","https://pythom-17c93.web.app/dict/do/6.html","https://pythom-17c93.web.app/dict/do/7.html"};
        }

    }
    public void progressbarinit(){
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        Sprite foldingcube = new FoldingCube();
        progressBar.setIndeterminateDrawable(foldingcube);
    }
    public void addinit(){
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
    }


}

