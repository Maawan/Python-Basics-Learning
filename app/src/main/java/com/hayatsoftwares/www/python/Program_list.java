package com.hayatsoftwares.www.python;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Program_list extends AppCompatActivity {

    private int identifier;
    private String[] webPageUrls;
    private String[] questions;
    private int cLass;
    private int position;
    private String title;


    @Override
    protected void onResume() {

//            Toast.makeText(this, "resume called", Toast.LENGTH_SHORT).show();
//            ArrayList<Heading> title = new ArrayList<>();
//            setTitle("Basic Programs");
//
//
//            title.add(new Heading("What is Python", 1, "https://pythom-17c93.firebaseapp.com/"));
//            title.add(new Heading("What is compiler and Interpreter ?", 2, "https://yahoo.com/"));
//            title.add(new Heading("What Python is Used", 2, "https://google.com"));
//            title.add(new Heading("What is compiler and Interpreter ?", 2, "https://yahoo.com/"));
//            title.add(new Heading("What Python is Used", 2, "https://google.com"));
//            title.add(new Heading("What is compiler and Interpreter ?", 2, "https://yahoo.com/"));
//            title.add(new Heading("What Python is Used", 2, "https://google.com"));
//            title.add(new Heading("What is compiler and Interpreter ?", 2, "https://yahoo.com/"));
//            title.add(new Heading("What Python is Used", 2, "https://google.com"));
//            title.add(new Heading("What is compiler and Interpreter ?", 2, "https://yahoo.com/"));
//            title.add(new Heading("What Python is Used", 2, "https://google.com"));
//            title.add(new Heading("What is compiler and Interpreter ?", 2, "https://yahoo.com/"));
//            title.add(new Heading("What Python is Used", 2, "https://google.com"));
//            title.add(new Heading("What is compiler and Interpreter ?", 2, "https://yahoo.com/"));
//            title.add(new Heading("What Python is Used", 2, "https://google.com"));
//            title.add(new Heading("What is compiler and Interpreter ?", 2, "https://yahoo.com/"));
//            title.add(new Heading("What Python is Used", 2, "https://google.com"));
//            title.add(new Heading("What is compiler and Interpreter ?", 2, "https://yahoo.com/"));
//            title.add(new Heading("What Python is Used", 2, "https://google.com"));
//            title.add(new Heading("What is compiler and Interpreter ?", 2, "https://yahoo.com/"));
//            title.add(new Heading("What Python is Used", 2, "https://google.com"));
//
//            RecyclerView list = (RecyclerView) findViewById(R.id.list);
//            HeadingAdapter adapter = new HeadingAdapter(this, title);
//            list.setAdapter(adapter);
//            list.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Heading> programsList = new ArrayList<>();
        setTitle(title);
        for(int i=0;i<webPageUrls.length;i++) {
            programsList.add(new Heading(questions[i], 1, webPageUrls[i]));
        }



        RecyclerView list = (RecyclerView)findViewById(R.id.list);
        list.setAdapter(new HeadingAdapter(this,programsList,cLass,(position+1)));
        list.setLayoutManager(new LinearLayoutManager(this));


        super.onResume();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "Stop Called", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_list);
        Bundle bundle = getIntent().getExtras();
        //Intent intent = getIntent();
        if( bundle !=null ) {
            identifier = bundle.getInt("identifier");
            webPageUrls = bundle.getStringArray("urls");
            questions = bundle.getStringArray("questions");
            position = bundle.getInt("position");
            cLass = bundle.getInt("cLass");
            title = bundle.getString("cardTitle");
        }

    }
}
