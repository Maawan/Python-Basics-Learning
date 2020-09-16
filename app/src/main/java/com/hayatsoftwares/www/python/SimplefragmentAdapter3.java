package com.hayatsoftwares.www.python;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimplefragmentAdapter3 extends FragmentPagerAdapter {

    public SimplefragmentAdapter3(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        if (position==0)
        {
            return new error_fragment_1();
        }
        else {
            return new error_fragement_2();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
