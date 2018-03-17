package com.lizheng.lottery.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.lizheng.lottery.R;
import com.lizheng.lottery.view.fragment.LuckPanLayout;
import com.lizheng.lottery.view.fragment.RotatePan;

import com.lizheng.lottery.base.BaseFragment;

/**
 * Created by lizheng on 2018/3/13.
 */

public class FindFragment extends BaseFragment implements LuckPanLayout.AnimationEndListener{

    private View view;
    private int time = 10000;
    private RotatePan rotatePan;
    private LuckPanLayout luckPanLayout;
    private ImageView goBtn;
    private ImageView yunIv;
    private String[] strs ;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = View.inflate(getContext(), R.layout.fragment_find,null);
        strs = getResources().getStringArray(R.array.names);
        luckPanLayout = (LuckPanLayout) view.findViewById(R.id.luckpan_layout);
        luckPanLayout.setAnimationEndListener(this);
        goBtn = (ImageView)view.findViewById(R.id.go);
        yunIv = (ImageView)view.findViewById(R.id.yun);
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                luckPanLayout.rotate(-1,100);
            }
        });
        return view;
    }

    @Override
    public void initData() {

    }
    @Override
    public void endAnimation(int position) {
        Toast.makeText(getContext(),"Position = "+position+","+strs[position],Toast.LENGTH_SHORT).show();
    }

}
