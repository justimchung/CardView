package com.example.justim.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by justim on 2017/12/19.
 */

public class ComicHouseFragmentPageAdapter extends FragmentPagerAdapter {
    static final int NUM_ITEMS = 3;

    public ComicHouseFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new ComicItemFragment();
        else
            return new MyFragment();
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "漫畫列表";
        else if(position == 1)
            return "我的最愛";
        else
            return "我的";
    }
}
