package com.hayatsoftwares.www.python;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class Program_list_by_class extends AppCompatActivity {
    private ViewPager viewPager;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_list_by_class);
        getSupportActionBar().hide();
        viewPager=(ViewPager)findViewById(R.id.container2);

        SimplefragmentAdapter2 adapter=new SimplefragmentAdapter2(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

        title=(TextView)findViewById(R.id.title);
        Typeface custom_font2 = Typeface.createFromAsset(getAssets(), "fonts/adventpro-light.ttf");
        title.setTypeface(custom_font2);
    }
}
