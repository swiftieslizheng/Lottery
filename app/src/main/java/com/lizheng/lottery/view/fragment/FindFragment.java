package com.lizheng.lottery.view.fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lizheng.lottery.base.BaseFragment;

/**
 * Created by lizheng on 2018/3/13.
 */

public class FindFragment extends BaseFragment {
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        TextView textView1 = new TextView(getContext());
        textView1.setGravity(Gravity.CENTER);
        textView1.setText("find");
        return textView1;
    }
}
