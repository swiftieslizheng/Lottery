package com.lizheng.lottery.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseActivity;
import com.lizheng.lottery.view.adapter.TrendImgAdapter;

/**
 * Created by Xie on 2018/3/25.
 */

public class TrendImgActivity extends BaseActivity {

    private GridView mGridView;
    private BaseAdapter mAdapter;
    private String[] data = {"期号","值","大","小","单","双","小单","大单","小双","大双"
                ,"868560","22","大","小","单","单","单","单","单","单",
                        "877470","18","单","单","单","单","单","单","单","单"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend_img);
        initView();
        initData();
    }

    public void initView() {
        mGridView = findViewById(R.id.gv_trend_img);
    }
    public void initData() {

        mAdapter = new TrendImgAdapter(data,this);
        mGridView.setAdapter(mAdapter);


    }

}
