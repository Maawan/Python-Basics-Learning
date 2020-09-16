package com.hayatsoftwares.www.python;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class program_fragment_1 extends Fragment {

    private View rootView;


    @Override
    public void onResume() {


        ArrayList<programModules> list = new ArrayList<programModules>();


        list.add(new programModules("Basic Python Programs","",new String[]{"Write a Program to display Hello World on Screen","Write a Program using many objects in Print( ) function","Write a Program to use sep argument in Print( ) function","Write a Program to use sep and end argument in Print( ) function","Write a Program to display sum of two numbers"},new String[]{
                "https://pythom-17c93.web.app/Programs/baiscPrograms/program1_helloWorld.html","https://pythom-17c93.web.app/Programs/baiscPrograms/program2.html","https://pythom-17c93.web.app/Programs/baiscPrograms/program3.html","https://pythom-17c93.web.app/Programs/baiscPrograms/program4.html","https://pythom-17c93.web.app/Programs/baiscPrograms/program5.html"},"Programs",11));


        list.add(new programModules("Programs on Mathematical Functions","",new String[]{"Write a Program to get 3 numbers from user and display their result","Write a Program to calculate area of triangle","Write a Program to calculate Circumfrance and Area of Circle","Write a Program to calculate BMI (Body Mass Index) of a Person and give Remarks also",
                "Write a Program to obtain fee amount and then calculate fee hike as 10 % of fees","Write a Program to print sum and Product of 4 numbers entered by the user","Write a Program to print sum of 2 numbers using input statement","Write a Program to calculate Simple Interest","Write a Program to obtain temperatures for 7 days and display the Average Temperature",
                "Write a Program to obtain seconds and display it in minutes and seconds"
                ,"Write a short program that asks for your height in centimetres and then converts your height to feet and inches","Write a Program to get a number from user and print n , n^2 , n^3","Write a Program to input a single digit(n) and prints a 3 digit number created as n(n+1)(n+2)","Write a Program to enter temperature in celcius and convert it into Fahrenheit"
                ,"Write a Program to enter marks of 5 subjects and get the Percentage"},new String[]{"https://pythom-17c93.web.app/Programs/mathFunctions/program1.html","https://pythom-17c93.web.app/Programs/mathFunctions/program2.html","https://pythom-17c93.web.app/Programs/mathFunctions/program3.html","https://pythom-17c93.web.app/Programs/mathFunctions/program4.html",
                "https://pythom-17c93.web.app/Programs/mathFunctions/program5.html","https://pythom-17c93.web.app/Programs/mathFunctions/program6.html","https://pythom-17c93.web.app/Programs/mathFunctions/program7.html","https://pythom-17c93.web.app/Programs/mathFunctions/program8.html","https://pythom-17c93.web.app/Programs/mathFunctions/program9.html",
                "https://pythom-17c93.web.app/Programs/mathFunctions/program10.html","https://pythom-17c93.web.app/Programs/mathFunctions/program11.html","https://pythom-17c93.web.app/Programs/mathFunctions/program12.html","https://pythom-17c93.web.app/Programs/mathFunctions/program13.html","https://pythom-17c93.web.app/Programs/mathFunctions/program14.html",
                "https://pythom-17c93.web.app/Programs/mathFunctions/program15.html"},"Programs",11));

        //list.add(new programModules("","",new String[]{},new String[]{},"programs",11));


        RecyclerView recyclerView = ( RecyclerView ) rootView.findViewById(R.id.recyclr);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new Adapter2(list,getContext()));

        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.program_list_fragment_1, container, false);
        return  rootView;
    }

}
