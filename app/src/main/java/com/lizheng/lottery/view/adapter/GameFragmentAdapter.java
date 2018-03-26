package com.lizheng.lottery.view.adapter;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;

/**
 * Created by lizheng on 2018/3/24.
 */

public class GameFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public GameFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments =fragments;
    }

    /**
     * 返回需要展示的fragment
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
