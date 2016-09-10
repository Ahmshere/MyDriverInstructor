package com.example.ahmshere.driverinstructor.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ahmshere.driverinstructor.fragments.FragmentOne;

public class TabFragmentAdapter extends FragmentPagerAdapter {
    private String []tabs;


    public TabFragmentAdapter(FragmentManager fm){
        super(fm);
        tabs = new String[]{
                "Vehicle", "About Instructor","Reviews"
        };

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return FragmentOne.getInstance();
            case 1:
                return FragmentOne.getInstance();
            case 2:
                return FragmentOne.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
