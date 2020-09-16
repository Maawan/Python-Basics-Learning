package com.hayatsoftwares.www.python;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.print.PrinterId;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class error_fragment_1 extends Fragment {
    private View rootView;



    @Override
    public void onResume() {
        ArrayList<Modules> list = new ArrayList<Modules>();
        list.add(new Modules("Python Fundamentals","",new String[]{"https://pythom-17c93.web.app/python_fundamentals/error/1.html", "https://pythom-17c93.web.app/python_fundamentals/error/2.html"
                , "https://pythom-17c93.web.app/python_fundamentals/error/3.html", "https://pythom-17c93.web.app/python_fundamentals/error/4.html", "https://pythom-17c93.web.app/python_fundamentals/error/5.html",
                "https://pythom-17c93.web.app/python_fundamentals/error/6.html", "https://pythom-17c93.web.app/python_fundamentals/error/7.html", "https://pythom-17c93.web.app/python_fundamentals/error/8.html"
                , "https://pythom-17c93.web.app/python_fundamentals/error/9.html", "https://pythom-17c93.web.app/python_fundamentals/error/10.html", "https://pythom-17c93.web.app/python_fundamentals/error/11.html",
                "https://pythom-17c93.web.app/python_fundamentals/error/12.html", "https://pythom-17c93.web.app/python_fundamentals/error/13.html", "https://pythom-17c93.web.app/python_fundamentals/error/14.html",
                "https://pythom-17c93.web.app/python_fundamentals/error/15.html", "https://pythom-17c93.web.app/python_fundamentals/error/16.html",
                "https://pythom-17c93.web.app/python_fundamentals/error/17.html", "https://pythom-17c93.web.app/python_fundamentals/error/18.html"},"error",11));
        list.add(new Modules("Data Handling","",new String[]{"https://pythom-17c93.web.app/data_handling/error/1.html", "https://pythom-17c93.web.app/data_handling/error/2.html"},"error",11));
        list.add(new Modules("Conditional and Loops","",new String[]{"https://pythom-17c93.web.app/conditional/error/1.html","https://pythom-17c93.web.app/conditional/error/2.html","https://pythom-17c93.web.app/conditional/error/3.html","https://pythom-17c93.web.app/conditional/error/4.html","https://pythom-17c93.web.app/conditional/error/5.html"},"error",11));
        list.add(new Modules("String Manipulation","",new String[]{"https://pythom-17c93.web.app/string/error/1.html","https://pythom-17c93.web.app/string/error/2.html","https://pythom-17c93.web.app/string/error/3.html"},"error",11));
        list.add(new Modules("List Manipulation","",new String[]{"https://pythom-17c93.web.app/list_manupulation/error/1.html","https://pythom-17c93.web.app/list_manupulation/error/2.html","https://pythom-17c93.web.app/list_manupulation/error/3.html"},"error",11));
        list.add(new Modules("Tuple","",new String[]{"https://pythom-17c93.web.app/tuple/error/1.html","https://pythom-17c93.web.app/tuple/error/2.html","https://pythom-17c93.web.app/tuple/error/3.html"},"error",11));
        list.add(new Modules("Dictionary","",new String[]{"https://pythom-17c93.web.app/dict/error/1.html"},"error",11));
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclr);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new Adapter(list,getContext()));

        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_error_fragment_1, container, false);
        return rootView;
    }
}