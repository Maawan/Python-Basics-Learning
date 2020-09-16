package com.hayatsoftwares.www.python;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class display_output_11 extends Fragment {
    private View rootView;
    @Override
    public void onResume() {
        ArrayList<Modules> list = new ArrayList<Modules>();
        list.add(new Modules("Python Fundamentals","",new String[]{"https://pythom-17c93.web.app/python_fundamentals/do/1.html", "https://pythom-17c93.web.app/python_fundamentals/do/2.html",
                "https://pythom-17c93.web.app/python_fundamentals/do/3.html", "https://pythom-17c93.web.app/python_fundamentals/do/4.html", "https://pythom-17c93.web.app/python_fundamentals/do/5.html"
                , "https://pythom-17c93.web.app/python_fundamentals/do/6.html", "https://pythom-17c93.web.app/python_fundamentals/do/7.html", "https://pythom-17c93.web.app/python_fundamentals/do/8.html", "https://pythom-17c93.web.app/python_fundamentals/do/9.html"
                , "https://pythom-17c93.web.app/python_fundamentals/do/10.html", "https://pythom-17c93.web.app/python_fundamentals/do/11.html", "https://pythom-17c93.web.app/python_fundamentals/do/12.html", "https://pythom-17c93.web.app/python_fundamentals/do/13.html"},"do",11));


        list.add(new Modules("Data Handling Outputs","",new String[]{"https://pythom-17c93.web.app/data_handling/do/1.html", "https://pythom-17c93.web.app/data_handling/do/2.html", "https://pythom-17c93.web.app/data_handling/do/3.html"
                , "https://pythom-17c93.web.app/data_handling/do/4.html", "https://pythom-17c93.web.app/data_handling/do/5.html", "https://pythom-17c93.web.app/data_handling/do/6.html", "https://pythom-17c93.web.app/data_handling/do/7.html",
                "https://pythom-17c93.web.app/data_handling/do/8.html", "https://pythom-17c93.web.app/data_handling/do/9.html", "https://pythom-17c93.web.app/data_handling/do/10.html", "https://pythom-17c93.web.app/data_handling/do/11.html",
                "https://pythom-17c93.web.app/data_handling/do/12.html", "https://pythom-17c93.web.app/data_handling/do/13.html", "https://pythom-17c93.web.app/data_handling/do/14.html", "https://pythom-17c93.web.app/data_handling/do/15.html", "https://pythom-17c93.web.app/data_handling/do/16.html",
                "https://pythom-17c93.web.app/data_handling/do/17.html", "https://pythom-17c93.web.app/data_handling/do/18.html", "https://pythom-17c93.web.app/data_handling/do/19.html", "https://pythom-17c93.web.app/data_handling/do/20.html",
                "https://pythom-17c93.web.app/data_handling/do/21.html"},"do",11));


        list.add(new Modules("Conditional and Loops","",new String[]{"https://pythom-17c93.web.app/conditional/do/1.html","https://pythom-17c93.web.app/conditional/do/2.html","https://pythom-17c93.web.app/conditional/do/3.html","https://pythom-17c93.web.app/conditional/do/4.html"
                ,"https://pythom-17c93.web.app/conditional/do/5.html","https://pythom-17c93.web.app/conditional/do/6.html","https://pythom-17c93.web.app/conditional/do/7.html","https://pythom-17c93.web.app/conditional/do/8.html","https://pythom-17c93.web.app/conditional/do/9.html","https://pythom-17c93.web.app/conditional/do/10.html"
                ,"https://pythom-17c93.web.app/conditional/do/11.html","https://pythom-17c93.web.app/conditional/do/12.html","https://pythom-17c93.web.app/conditional/do/13.html"},"do",11));


        list.add(new Modules("String Manipulation","",new String[]{"https://pythom-17c93.web.app/string/do/1.html","https://pythom-17c93.web.app/string/do/2.html","https://pythom-17c93.web.app/string/do/3.html","https://pythom-17c93.web.app/string/do/4.html",
                "https://pythom-17c93.web.app/string/do/5.html","https://pythom-17c93.web.app/string/do/6.html","https://pythom-17c93.web.app/string/do/7.html","https://pythom-17c93.web.app/string/do/8.html"},"do",11));


        list.add(new Modules("List Manipulation","",new String[]{"https://pythom-17c93.web.app/list_manupulation/do/1.html","https://pythom-17c93.web.app/list_manupulation/do/2.html","https://pythom-17c93.web.app/list_manupulation/do/3.html",
                "https://pythom-17c93.web.app/list_manupulation/do/4.html","https://pythom-17c93.web.app/list_manupulation/do/5.html","https://pythom-17c93.web.app/list_manupulation/do/6.html","https://pythom-17c93.web.app/list_manupulation/do/7.html","https://pythom-17c93.web.app/list_manupulation/do/8.html"},"do",11));

        list.add(new Modules("Tuple","",new String[]{"https://pythom-17c93.web.app/tuple/do/1.html","https://pythom-17c93.web.app/tuple/do/2.html","https://pythom-17c93.web.app/tuple/do/3.html","https://pythom-17c93.web.app/tuple/do/4.html","https://pythom-17c93.web.app/tuple/do/5.html"},"do",11));

        list.add(new Modules("Dictionary","",new String[]{"https://pythom-17c93.web.app/dict/do/1.html","https://pythom-17c93.web.app/dict/do/2.html","https://pythom-17c93.web.app/dict/do/3.html","https://pythom-17c93.web.app/dict/do/4.html","https://pythom-17c93.web.app/dict/do/5.html","https://pythom-17c93.web.app/dict/do/6.html","https://pythom-17c93.web.app/dict/do/7.html"},"do",11));


        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclr);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new Adapter(list,getContext()));
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_display_11, container, false);
        return rootView;
    }


}
