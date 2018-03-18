package com.lizheng.lottery.view.fragment.person;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseFragment;

/**
 * Created by lizheng on 2018/3/13.
 */

public class PersonFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_person,null);
        return view;
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        TextView textView1 = new TextView(getContext());
        textView1.setGravity(Gravity.CENTER);
        textView1.setText("person");
        return textView1;
    }

    @Override
    public void initData() {

    }
}
