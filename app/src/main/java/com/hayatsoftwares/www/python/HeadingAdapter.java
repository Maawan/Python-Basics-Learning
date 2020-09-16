package com.hayatsoftwares.www.python;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.MODE_PRIVATE;
import static com.hayatsoftwares.www.python.MainActivity.SHARED_PREF;

public class HeadingAdapter extends RecyclerView.Adapter<HeadingAdapter.ViewHolder> {
    TextView s_no;
    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    int b;
    private ArrayList<Heading> words;
    private Context context;
    String temp;
    private int cLass;
    private int card_no;




    public HeadingAdapter(Activity context, ArrayList<Heading> words,int cLass,int cardNo) {
        this.context=context;
         this.words=words;
         this.cLass = cLass;
         this.card_no = cardNo;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
         b =position;
        b=b+1;
        final Heading currentheading =words.get(position);

        holder.title.setText(currentheading.getmTitle());


        String roll_id = String.valueOf(b);
        holder.s_no.setText(roll_id+".");
        initialsie_firebase();
        temp=currentheading.getMurl();
        //ReadFromDatabase();

        final DatabaseReference ref = firebaseDatabase.getReference("Users_Database/"+user.getUid()+"/Programs/"+cLass+"/"+card_no+"/"+position);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue(Long.class)!=null) {
                    Long value = dataSnapshot.getValue(Long.class);
                    //Log.d(TAG, "Value is: " + value);

                    // Toast.makeText(getActivity(), "Value is " + value, Toast.LENGTH_SHORT).show();
                    if(value==1) {
                            //holder.s_no.setText("Done");
                            holder.check.setVisibility(View.VISIBLE);
//                          holder.check.setAlpha(0f);
//                          //holder.check.setVisibility(View.VISIBLE);
                            holder.s_no.setVisibility(View.INVISIBLE);
//                          holder.check.animate()
//                                  .alpha(1f).setDuration(1500).setListener(null);
//
//                          //holder.s_no.setVisibility(View.GONE);
//
//                          holder.s_no.animate()
//                                  .alpha(0f)
//                                  .setDuration(1500)
//                                  .setListener(new Animator.AnimatorListener() {
//                                      @Override
//                                      public void onAnimationStart(Animator animator) {
//                                      }
//
//                                      @Override
//                                      public void onAnimationEnd(Animator animator) {
//                                          holder.s_no.setVisibility(View.GONE);
//
//                                      }
//
//                                      @Override
//                                      public void onAnimationCancel(Animator animator) {
//
//                                      }
//
//                                      @Override
//                                      public void onAnimationRepeat(Animator animator) {
//
//                                      }
//                                  });



                    }
                }
                else {
                    ref.setValue(0);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent intent=new Intent(context,learn.class).putExtra("url",currentheading.getMurl());
                    intent.putExtra("identifier",position);
                    intent.putExtra("cardNo",card_no);
                    intent.putExtra("cLass",cLass);

                    context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {

        return  this.words.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private View parentView;
        private ImageView check;
        private TextView s_no;

        public ViewHolder(View view){
            super(view);
            this.parentView=view;
            this.check=(ImageView)view.findViewById(R.id.check);
            this.title=(TextView)view.findViewById(R.id.title1);
            this.s_no = (TextView) view.findViewById(R.id.s_no);


        }
    }
    private void initialsie_firebase(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        user = firebaseAuth.getCurrentUser();
    }
}
