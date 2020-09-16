package com.hayatsoftwares.www.python;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;

import android.graphics.drawable.ColorDrawable;
import android.net.Uri;


import android.os.Bundle;


import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;



public class MainActivity extends AppCompatActivity {
    ImageView user_image;
    TextView mail_name;
    private Dialog help_dialog;
    TextView username;
    final String TAG="Error";
    ImageView close;
    Bundle data1;
    CardView card_user_info,help_card;
    TextView learn_progress_test,program_progress_test;
    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    CircularProgressBar circularProgressBar ,circularProgressBar2;
    String value;

    String MAIL;
    TextView learn,program;
    private static final String DEFAULT_PATTERN = "%d%%";
    TextView status;
    public static final String SHARED_PREF="sharedPref";

    String url;
    


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Don't Press Back Button", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.know) {
            Intent intent =new Intent(MainActivity.this,About.class);
            startActivity(intent);

        }else if(id==R.id.more) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/dev?id=9206445165045335843&hl=en"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent
                    .FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
        else if(id==R.id.privacy) {
            Intent intent=new Intent(MainActivity.this,privacy_policy.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.heading);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);
        help_card = (CardView)findViewById(R.id.help_card);
        help_dialog=new Dialog(this);
        initialise_Dialog();
        // DataBase init
        firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        final FirebaseUser user=firebaseAuth.getCurrentUser();
        databaseReference=firebaseDatabase.getReference("Users/"+user.getUid());

         circularProgressBar= findViewById(R.id.circularProgressBar1);
        circularProgressBar2= findViewById(R.id.circularProgressBar2);
       // refresh(57,82);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);


        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.desc_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.desc_2));
        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
//        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
//                dpToPixels(2, this));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
       //mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        card_user_info=(CardView)findViewById(R.id.card_view4);


        learn=(TextView)findViewById(R.id.learn_progress_text);
        program=(TextView)findViewById(R.id.program_progress_text);
        status=(TextView)findViewById(R.id.status);
        user_image=(ImageView)findViewById(R.id.profile_image);
        program_progress_test=(TextView)findViewById(R.id.program_progress_text);
        learn_progress_test=(TextView)findViewById(R.id.learn_progress_text);
        help_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                help_dialog.show();
            }
        });


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Bundle bundle = new Bundle();
             value = extras.getString("USERNAME");
            MAIL = extras.getString("MAIL");
            url=extras.getString("IMAGE");
           // Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
            Glide.with(this).load(url).fitCenter().into(user_image);
            savedata_pref();
            data1=new Bundle();
            data1.putString("USERNAME",value);
            data1.putString("MAIL",MAIL);
            data1.putString("IMAGE",url);
            }
            else
        {
            loaddata_pref();
            data1=new Bundle();
            data1.putString("USERNAME",value);
            data1.putString("MAIL",MAIL);
            data1.putString("IMAGE",url);
            Glide.with(this).load(url).fitCenter().into(user_image);
        }



        TextView help = (TextView) findViewById(R.id.help);
         username = (TextView) findViewById(R.id.user);
         if(value.length()>12)
         {username.setTextSize(14);}
         username.setText(value);


         mail_name = (TextView) findViewById(R.id.mail);
         mail_name.setText(MAIL);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/adventprobold.ttf");
        //help1.setTypeface(custom_font);
        learn.setTypeface(custom_font);
        program.setTypeface(custom_font);
        username.setTypeface(custom_font);
        status.setTypeface(custom_font);
        mail_name.setTypeface(custom_font);

        help.setTypeface(custom_font);





        card_user_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(MainActivity.this,User_Profile.class).putExtras(data1);
                Pair[] pairs=new Pair[7];
                pairs[0]=new Pair<View,String>(user_image,"image");
                pairs[1]=new Pair<View,String>(username,"username_1");
                pairs[2]=new Pair<View,String>(mail_name,"mail_1");
                pairs[3]=new Pair<View,String>(circularProgressBar,"learn_bar");
                pairs[4]=new Pair<View,String>(circularProgressBar2,"progress_bar");
                pairs[5]=new Pair<View,String>(learn_progress_test,"learn_status");
                pairs[6]=new Pair<View,String>(program_progress_test,"progress_status");

                ActivityOptions options = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                }

                startActivity(intent,options.toBundle());
            }
        });
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                if(dataSnapshot.getValue()!=null) {
                    Database_Values database_values = dataSnapshot.getValue(Database_Values.class);
                    refresh(database_values.getProgram(),database_values.getLearn());
                    //Toast.makeText(MainActivity.this, friendlyMessage.getLearn() + " " + " " + friendlyMessage.getProgram(), Toast.LENGTH_SHORT).show();
                }
                else{
                    // Toast.makeText(MainActivity.this, "You are a new user right ?", Toast.LENGTH_SHORT).show();
                    databaseReference.setValue(new Database_Values(user.getDisplayName(),user.getEmail(),0,0));
                    refresh(0,0);

                }// ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("ABC", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        databaseReference.addValueEventListener(postListener);

    }
    public void savedata_pref()
    {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("USERNAME",value);
        editor.putString("MAIL_ID",MAIL);
        editor.putString("URL",url);
        editor.apply();


    }
    public void loaddata_pref() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        value = sharedPreferences.getString("USERNAME", "");
        MAIL = sharedPreferences.getString("MAIL_ID", "");
        url = sharedPreferences.getString("URL", "");
    }
    private void refresh(int a,int b) {
            long temp1=3000;
            circularProgressBar2.setProgressWithAnimation(a,temp1);
            circularProgressBar.setProgressWithAnimation(b,temp1);
            circularProgressBar.setProgressBarColorStart(Color.BLUE);
            circularProgressBar.setProgressBarColorEnd(Color.parseColor("#64B5F6"));
            circularProgressBar2.setProgressBarColorStart(Color.BLUE);
            circularProgressBar2.setProgressBarColorEnd(Color.parseColor("#64B5F6"));
        }
    private void initialise_Dialog(){
        help_dialog.setContentView(R.layout.help);
        close=(ImageView)help_dialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                help_dialog.dismiss();
            }
        });
        help_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }







}