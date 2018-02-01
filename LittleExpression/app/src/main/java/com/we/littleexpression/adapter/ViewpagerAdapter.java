package com.we.littleexpression.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.we.littleexpression.pages.page1;

/**
 * Created by Fan on 2018/2/1.
 */

public class ViewpagerAdapter extends FragmentPagerAdapter {
    private String[] title={"小坏坏","小猥琐","小凶凶","小黄狗"};
    public ViewpagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        if(position==2) return new page1();
        if(position==1) return new page1();
        return new page1();
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

}