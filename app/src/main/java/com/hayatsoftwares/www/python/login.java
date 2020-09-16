package com.hayatsoftwares.www.python;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class login extends AppCompatActivity {
    private static final int RC_SIGN_IN =32120;
    GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    ProgressBar progress;
    TextView hayat,head;
    ImageView prof;
    Bitmap bitmap;
    private CardView progressCard;
    String name;
    Dialog no;
    String img_url;
    Button btn;
    TextView title,title_2;
    ImageView close,network;



    @Override
    protected void onStart() {
        super.onStart();

        //if the user is already signed in
        //we will close this activity
        //and take the user to profile activity
        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
//        Intent intent=new Intent(login.this,MainActivity.class);
//        startActivity(intent);
        getSupportActionBar().hide();
        hayat=(TextView)findViewById(R.id.hayat);
        progressCard = (CardView)findViewById(R.id.progressCard);
        head=(TextView)findViewById(R.id.heading);
        no=new Dialog(this);
        initialise_Dialog();

        //   sign=(Button)findViewById(R.id.sign_in_button);
        progress = (ProgressBar) findViewById(R.id.progress);
        progress.setVisibility(View.GONE);
        progressCard.setVisibility(View.GONE);
        if (FirebaseAuth.getInstance().getCurrentUser()!=null){

            Intent intent = new Intent(login.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("535267281927-lbc4kblu4dn5tt5gmf5uoriajaor44sp.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        TextView hayat1 = (TextView) findViewById(R.id.hayat1);
        Typeface custom_font2 = Typeface.createFromAsset(getAssets(), "fonts/adventpro-light.ttf");
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/adventprobold.ttf");
        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    Toast.makeText(login.this, "Sign IN Button is beeing Pressed", Toast.LENGTH_SHORT).show();
                if(!isNetworkAvailable()){
                    no.show();
                }else {
                progress.setVisibility(View.VISIBLE);
                progressCard.setVisibility(View.VISIBLE);
                signIn();
               findViewById(R.id.sign_in_button).setEnabled(false);
                }
            }

        });

        head.setTypeface(custom_font);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,MainActivity.class);
                startActivity(intent);
            }
        });
        hayat.setTypeface(custom_font2);
        hayat1.setTypeface(custom_font);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if the requestCode is the Google Sign In code that we defined at starting
        if (requestCode == RC_SIGN_IN) {

            //Getting the GoogleSignIn Task
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                //Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);

                //authenticating with firebase
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                //progressBar.setVisibility(View.GONE);
                Log.e("Error","Error in Login");
                Toast.makeText(this, "Catched Exception", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void firebaseAuthWithGoogle(final GoogleSignInAccount acct) {
        Log.d("rjkndv", "firebaseAuthWithGoogle:" + acct.getId());

        //getting the auth credential
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("rndk", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            progress.setVisibility(View.GONE);
                            progressCard.setVisibility(View.GONE);


                            name=acct.getDisplayName();
                            img_url=acct.getPhotoUrl().toString();
                            String mail=acct.getEmail();
                            Bundle data=new Bundle();
                            data.putString("USERNAME",name);
                            data.putString("MAIL",mail);
                            data.putString("IMAGE",img_url);



                           Intent intent=new Intent(login.this,MainActivity.class);
                           intent.putExtras(data);
                           startActivity(intent);



                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("jhfvdjk", "signInWithCredential:failure", task.getException());
                            Toast.makeText(login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                           progress.setVisibility(View.GONE);
                           progressCard.setVisibility(View.GONE);

                        }
                    }
                });
    }

    private void signIn() {
        //getting the google signin intent
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
       // progressBar.setVisibility(View.VISIBLE);


        //starting the activity for result
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    public void initialise_Dialog(){
        no.setContentView(R.layout.no_network);
        close=(ImageView)no.findViewById(R.id.close);
        btn=(Button)no.findViewById(R.id.retry_btn);
        title=(TextView)no.findViewById(R.id.title);
        title_2=(TextView)no.findViewById(R.id.title_2);
        network=(ImageView)no.findViewById(R.id.vector);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no.dismiss();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no.dismiss();
            }
        });
        no.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}