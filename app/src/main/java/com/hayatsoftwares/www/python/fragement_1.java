package com.hayatsoftwares.www.python;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jorgecastilloprz.progressarc.ProgressArcView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class fragement_1 extends Fragment {
    private View rootView;


    @Override
    public void onStop() {
      //  Toast.makeText(getActivity(), "OnStop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    public void onStart() {
        //Toast.makeText(getActivity(), "Onstart", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    public void onResume() {
        Toast.makeText(getContext(), "OnResume is Called", Toast.LENGTH_SHORT).show();
        ArrayList<Modules> list = new ArrayList<Modules>();
        list.add(new Modules("Introduction","What is a Language, How a Computer runs a Program ?, What is a Compiler and Interpreter ?, What is Python ?, Evolution of Python" +
                " ?,how to get Started in Python ",new String[]{"https://chayatsoftwares.000webhostapp.com/webpage_1-1.html",
                "https://chayatsoftwares.000webhostapp.com/webpage_1-2.html","https://chayatsoftwares.000webhostapp.com/webpage_1-3.html","https://chayatsoftwares.000webhostapp.com/webpage_1-4.html","https://chayatsoftwares.000webhostapp.com/webpage_1-5.html","https://chayatsoftwares.000webhostapp.com/webpage_1-6.html"},"python_concepts",11));
        list.add(new Modules("Python Fundamentals","Character Set, Keywords, Identifier, Literals, Creating a Variable, Variable Definition, Reading Numbers, Output using Print() function",new String[]{"https://chayatsoftwares.000webhostapp.com/webpage_2-1.html",
                "https://chayatsoftwares.000webhostapp.com/webpage_2-2.html","https://chayatsoftwares.000webhostapp.com/webpage_2-3.html","https://chayatsoftwares.000webhostapp.com/webpage_2-4.html","https://chayatsoftwares.000webhostapp.com/webpage_2-5.html","https://www.java.com/","https://www.dell.com/"},"python_concepts",11));
        list.add(new Modules("Data Handling","Data Types, Lists, Dictionary, Arithmetic, Relational, Identity, Logical Operators, Type Casting",new String[]{"https://www.google.com","https://www.amazon.in"},"python_concepts",11));
        list.add(new Modules("Conditional and Loops","Flow Control, Decision making Statements ,range() function, for loop, while loop, Iteration Principles, Nested Loops",new String[]{"https://www.google.com","https://www.amazon.in"},"python_concepts",11));
        list.add(new Modules("String Manipulation","Intro, Transversing a String, String Operators, String Slices, String functions and Methods",new String[]{"https://www.google.com","https://www.amazon.in"},"python_concepts",11));
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclr);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new Adapter(list,getContext()));
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.fragment_python_conepts_all, container, false);
       return rootView;
    }


}
