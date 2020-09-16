package com.hayatsoftwares.www.python;


import android.os.Bundle;



import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;


public class activity_main3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ArrayList<Heading> title=new ArrayList<>();
        setTitle("Learn");
//        URL url=http://www.cppexampler.com/what-is-c-how-can-we-define-it/;
        title.add(new Heading("What is C++ ? How can we Start coding in it",1,"https://hayat-softwares.000webhostapp.com/why_python.html"));
        title.add(new Heading("It is Second File",1,"https://hotstar.com"));
        title.add(new Heading("It is Third File",1,"https://youtube.com"));
        title.add(new Heading("It is Fourth File",1,"https://pogo.tv"));
        title.add(new Heading("It is Fifth File",1,"https://google.com"));
        title.add(new Heading("It is Sixth File",1,"https://amazon.com"));
        title.add(new Heading("It is Seventh File",1,"https://flipkart.com"));
        title.add(new Heading("It is Eight File",1,"https://snapdeal.com"));
        title.add(new Heading("It is Second File",1,"https://zoomcar.com"));
        title.add(new Heading("It is Second File",1,"https://hayatsoftwares.com"));
        title.add(new Heading("It is Second File",1,"https://dell.com"));
        title.add(new Heading("It is Second File",1,"https://techburner.com"));
        title.add(new Heading("It is Second File",1,"https://lapaas.com"));
        title.add(new Heading("It is Second File",1,"https://gmail.com"));




//        RecyclerView list=(RecyclerView) findViewById(R.id.list);
//        HeadingAdapter adapter=new HeadingAdapter(this,title);
//        list.setAdapter(adapter);
//        list.setLayoutManager(new LinearLayoutManager(this));

    }
}
