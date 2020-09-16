package com.hayatsoftwares.www.python;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;
//import me.grantland.widget.AutofitHelper;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Python_concepts_list extends AppCompatActivity {
    private TextView title;
    private ProgressBar progress1;
    private TextView card1_title,card2_title,card3_title,card4_title,card5_title,card6_title,card1_desc,card2_desc,card3_desc,card4_desc,card5_desc,card6_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_python_concepts_list);getSupportActionBar().hide();

        title=(TextView)findViewById(R.id.title);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/adventprobold.ttf");
        title.setTypeface(custom_font);
        Declare();
        card1_title.setText("Introduction");
        card1_desc.setText("What is a Language, evolution of python, Role of an Operating System in running a Program, how to get started ");
        card2_title.setText("Python Fundamentals");
        card2_desc.setText("Keywords, Identifier, Literals, Creating a Variable, Variable Definition, Reading Numbers, Output using Print()");
        progress1.setProgress(40);
        card3_title.setText("Data Handling");
        card3_desc.setText("Data Types, Lists, Dictionary, Arithmetic, Relational, Identity, Logical Operators, Type Casting");
        card4_title.setText("Conditional and Loops");
        card4_desc.setText("Flow Control, Decision making Statements ,range() function, for loop, while loop, Iteration Principles, Nested Loops");
        card5_title.setText("String Manipulation");
        card5_desc.setText("Intro, Transversing a String, String Operators, String Slices, String functions and Methods");


    }














    private void Declare()
    {
        card1_title=(TextView)findViewById(R.id.card1_title);
        progress1=(ProgressBar)findViewById(R.id.progress1);
        card2_title=(TextView)findViewById(R.id.card2_title);
        card3_title=(TextView)findViewById(R.id.card3_title);
        card4_title=(TextView)findViewById(R.id.card4_title);
        card5_title=(TextView)findViewById(R.id.card5_title);
        card6_title=(TextView)findViewById(R.id.card6_title);
        card1_desc=(TextView)findViewById(R.id.card1_desc);
        card2_desc=(TextView)findViewById(R.id.card2_desc);
        card3_desc=(TextView)findViewById(R.id.card3_desc);
        card4_desc=(TextView)findViewById(R.id.card4_desc);
        card5_desc=(TextView)findViewById(R.id.card5_desc);
        card6_desc=(TextView)findViewById(R.id.card6_desc);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card1_title,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card2_title,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card3_title,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card4_title,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card5_title,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card6_title,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card1_desc,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card2_desc,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card3_desc,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card4_desc,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card5_desc,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
//        TextViewCompat.setAutoSizeTextTypeWithDefaults(card6_desc,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
    }
}
