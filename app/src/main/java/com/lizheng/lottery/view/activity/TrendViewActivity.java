package com.lizheng.lottery.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseActivity;
import com.lizheng.lottery.bean.TrendViewBean;
import com.lizheng.lottery.view.adapter.TrendViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xie on 2018/3/26.
 */

public class TrendViewActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView mRecyclerTrend;
    private TrendViewAdapter mAdapter;
    private List<TrendViewBean> mList;
    private TextView ts_trend_history;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend_view);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        initView();
        initData();

    }

    public void initView() {
        mRecyclerTrend = findViewById(R.id.rv_trend);
        ts_trend_history = findViewById(R.id.ts_trend_history);
    }
    public void initData() {
        mList = new ArrayList<>();
        TrendViewBean bean = new TrendViewBean("第866850期","8+7+7=22（大双）");
        mList.add(bean); mList.add(bean); mList.add(bean); mList.add(bean); mList.add(bean); mList.add(bean);

        mAdapter = new TrendViewAdapter(mList,this);
        mRecyclerTrend.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerTrend.setAdapter(mAdapter);

        ts_trend_history.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,TrendImgActivity.class);
        startActivity(intent);
    }
}
