package com.hayatsoftwares.www.python;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase database;
    int sum;
    private int[] ProgressRecord = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private ArrayList<Modules> mList;
    private Context contxt;
    private String[] tempArray = new String[20];

    private int arraySize;
    //private RoundedHorizontalProgressBar progressBar

    public Adapter(ArrayList<Modules> list , Context context){
        mList = list;
        contxt = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title , desc ,  button;
        public RoundedHorizontalProgressBar progressBar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.titleView);
            desc = (TextView)itemView.findViewById(R.id.descView);
            progressBar = (RoundedHorizontalProgressBar) itemView.findViewById(R.id.progress_bar);
            button = (TextView)itemView.findViewById(R.id.button);
        }
    }
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_layout, parent, false);
        MyViewHolder v = new MyViewHolder(rootView);
        initiateFirebase();
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, final int position) {
        if(mList.get(position).getIdentifer().equals("error")   || mList.get(position).getIdentifer().equals("do") || mList.get(position).getIdentifer().equals("Programs")){
            int sizeTemp = mList.get(position).getUrls().length;
            if(mList.get(position).getIdentifer().equals("Programs")) {
                mList.get(position).setmDesc("Contains "+ (sizeTemp/2) +" Programs");
                //mList.get(position).setUrls(tempArray);
            }else {
                mList.get(position).setmDesc("Contains " + sizeTemp + " Problems");
            }
        }

        holder.title.setText(mList.get(position).getmTitle());
        holder.desc.setText(mList.get(position).getmDesc());
        holder.progressBar.setProgress(0);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contxt, "You have click on " + position +" element", Toast.LENGTH_SHORT).show();
                Bundle temp_bundle = new Bundle();
                temp_bundle.putStringArray("urls",mList.get(position).getUrls());
                temp_bundle.putString("identifier",mList.get(position).getIdentifer());
                temp_bundle.putInt("cLass",mList.get(position).getcLass());
                temp_bundle.putInt("position",position);
                temp_bundle.putString("cardTitle",mList.get(position).getmTitle());

                if(mList.get(position).getIdentifer().equals("Programs")){
                     contxt.startActivity(new Intent(contxt,Program_list.class).putExtras(temp_bundle));
                }else {
                    contxt.startActivity(new Intent(contxt,learn_lectures.class).putExtras(temp_bundle));
                    Toast.makeText(contxt, "You have tapped on " + Integer.toString(position), Toast.LENGTH_SHORT).show();
                }

            }
        });
        refreshProgressBar(position,holder.progressBar);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    private void initiateFirebase(){
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
    }
    private void refreshProgressBar(final int position, final RoundedHorizontalProgressBar bar){
        arraySize = mList.get(position).getUrls().length;
        for(int i=0;i<arraySize;i++){
            final DatabaseReference reference = database.getReference("Users_Database/"+firebaseUser.getUid()+"/"+mList.get(position).getIdentifer()+"/"+mList.get(position).getcLass()+"/"+(position+1)+"/"+i);
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.getValue(Long.class)!=null){
                        Long tempValue = snapshot.getValue(Long.class);
                        if(tempValue == 1){
                            sum++;
                            ProgressRecord[position] += 1;
                            if(position == 0){
                                Toast.makeText(contxt, Integer.toString(sum), Toast.LENGTH_SHORT).show();
                            }
                            reflectToProgressBar(sum,bar,position);
                        }
                    }else {
                        reference.setValue(0);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

    }
    private void reflectToProgressBar(int sum,RoundedHorizontalProgressBar bar,int position){
        int length = mList.get(position).getUrls().length;
        int progressLength = (ProgressRecord[position]*100)/length;
        progressAnimation(bar,progressLength);
    }
    private void progressAnimation(RoundedHorizontalProgressBar progressBar,int progressBarLength){
        progressBar.animateProgress(1000,0,progressBarLength);

    }
    private void copyIntoTemp(String[] paraArray){
        int j = 0;
        for(int i = 1 ; i < paraArray.length ; i = i+2){
            tempArray[j] = paraArray[i];
            j++;
        }
    }

}

