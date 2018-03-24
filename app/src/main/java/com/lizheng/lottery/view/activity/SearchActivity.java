package com.lizheng.lottery.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseActivity;
import com.lizheng.lottery.bean.FollowBean;
import com.lizheng.lottery.utils.ActivityController;
import com.lizheng.lottery.view.adapter.FollowAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private List<FollowBean> followList;
    private FollowAdapter mAdapter;
    private ImageButton btn_bacck;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    private void initView() {
        btn_bacck = findViewById(R.id.btn_bcak);
        tv_title = findViewById(R.id.txt_title);
        tv_title.setText("搜索");
        btn_bacck.setVisibility(View.VISIBLE);
        mRecyclerView = findViewById(R.id.rv_search);
        //设置为线性布局排列
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initData() {
        followList = new ArrayList<>();

        initFollows();

        btn_bacck.setOnClickListener(this);
        //设置适配器
        mAdapter = new FollowAdapter(this,followList);
        mAdapter.setItemListener(new FollowAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(SearchActivity.this,FollowDetailActivity.class);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initFollows() {
        for (int i = 0; i < 2; i++) {
            FollowBean follow1 = new FollowBean(1, "", "赌神一号", "赌神一号：无视赔半，4.6.2.1，每周2，4...", "加拿大");
            followList.add(follow1);
            FollowBean follow2 = new FollowBean(1, "", "赌神二号", "赌神一号：无视赔半，4.6.2.1，每周2，4...", "加拿大");
            followList.add(follow2);
            FollowBean follow3 = new FollowBean(1, "", "赌神三号", "赌神一号：无视赔半，4.6.2.1，每周2，4...", "加拿大");
            followList.add(follow3);
            FollowBean follow4 = new FollowBean(1, "", "赌神四号", "赌神一号：无视赔半，4.6.2.1，每周2，4...", "加拿大");
            followList.add(follow4);
        }
    }

    /**
     * 点击事件回调
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_bcak:
                finish();
                ActivityController.removeActivity(this);
                break;
            default:
                break;
        }
    }
}
