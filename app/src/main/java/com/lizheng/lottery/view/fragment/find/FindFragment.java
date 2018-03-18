package com.lizheng.lottery.view.fragment.find;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.lizheng.lottery.R;

import com.lizheng.lottery.base.BaseFragment;
import com.lizheng.lottery.view.activity.find.GameLeftActivity;
import com.lizheng.lottery.view.activity.find.GameRightActivity;

/**
 * Created by lizheng on 2018/3/13.
 */

public class FindFragment extends BaseFragment implements LuckPanLayout.AnimationEndListener,View.OnClickListener{

    private View view;
    private int time = 10000;
    private RotatePan rotatePan;
    private LuckPanLayout luckPanLayout;
    private ImageView goBtn;
    private ImageView yunIv;
    private String[] strs ;
    private ImageView img_game_left;
    private ImageView img_game_right;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = View.inflate(getContext(), R.layout.fragment_find,null);
        //画转盘的操作
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

        img_game_left = view.findViewById(R.id.img_game_left);
        img_game_right = view.findViewById(R.id.img_game_right);
        return view;
    }

    @Override
    public void initData() {
        img_game_left.setOnClickListener(this);
        img_game_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_game_left:
                Intent intent = new Intent();
                intent.setClass(getContext(), GameLeftActivity.class);
                startActivity(intent);
                break;
            case R.id.img_game_right:
                Intent intent2 = new Intent();
                intent2.setClass(getContext(), GameRightActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }

    @Override
    public void endAnimation(int position) {
        Toast.makeText(getContext(),"Position = "+position+","+strs[position],Toast.LENGTH_SHORT).show();
    }

}
