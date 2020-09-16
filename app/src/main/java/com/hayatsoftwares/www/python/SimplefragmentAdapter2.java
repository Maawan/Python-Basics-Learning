package com.hayatsoftwares.www.python;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimplefragmentAdapter2 extends FragmentPagerAdapter {

    public SimplefragmentAdapter2(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        if (position==0)
        {
            return new program_fragment_1();
        }
        else {
            return new program_fragment_2();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
