package com.lizheng.lottery.view.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseActivity;

public class FollowDetailActivity extends BaseActivity {
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_detail);
        tv_title = findViewById(R.id.txt_title);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_title.setText("详情资料");
    }
}
