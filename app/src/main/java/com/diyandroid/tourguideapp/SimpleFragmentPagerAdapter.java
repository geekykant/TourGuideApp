package com.diyandroid.tourguideapp;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[]{"Tourist Spots", "Hotels", "Restaurant", "Beaches"};
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        if (position == 0) {
            return new TouristSpots();
        } else if (position == 1) {
            return new Hotels();
        } else if (position == 2) {
            return new Restaurant();
        } else {
            return new Beaches();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}