package com.hayatsoftwares.www.python;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimplefragmentAdapter extends FragmentPagerAdapter {

    public SimplefragmentAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        if (position==0)
        {
            return new fragement_1();
        }
        else {
            return new fragment_2();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
