package com.hayatsoftwares.www.python;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimplefragmentAdapter4 extends FragmentPagerAdapter {
    public SimplefragmentAdapter4(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0)
        {
            return new display_output_11();
        }
        else {
            return new display_output_12();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
