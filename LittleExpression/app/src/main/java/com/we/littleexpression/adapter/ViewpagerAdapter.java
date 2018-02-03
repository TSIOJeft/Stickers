package com.we.littleexpression.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.we.littleexpression.pages.page1;
import com.we.littleexpression.pages.page2;
import com.we.littleexpression.pages.page3;
import com.we.littleexpression.pages.page4;

/**
 * Created by Fan on 2018/2/1.
 */

public class ViewpagerAdapter extends FragmentPagerAdapter {
    private String[] title = {"小坏坏", "小猥琐", "小凶凶", "小黄狗"};
    private Fragment[] fragments = new Fragment[title.length];

    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments[position] == null) {
            if (position == 0) fragments[position] = new page1();
            if (position == 1) fragments[position] = new page2();
            if (position == 2) fragments[position] = new page3();
            if (position == 3) fragments[position] = new page4();
        }
        return fragments[position];
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