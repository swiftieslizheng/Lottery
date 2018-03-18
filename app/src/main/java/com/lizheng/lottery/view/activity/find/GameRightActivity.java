package com.lizheng.lottery.view.activity.find;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseActivity;

/**
 * Created by Xie on 2018/3/18.
 */

public class GameRightActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_game);
        initView();
        initData();

    }

    public void initView() {
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setText("我是右界面");
    }

    public void initData() {

    }
}
