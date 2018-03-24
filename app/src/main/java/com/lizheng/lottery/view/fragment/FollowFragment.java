package com.lizheng.lottery.view.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseFragment;
import com.lizheng.lottery.bean.FollowBean;
import com.lizheng.lottery.view.activity.FollowDetailActivity;
import com.lizheng.lottery.view.adapter.FollowAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizheng on 2018/3/13.
 * 已关注页面的fragment
 */

public class FollowFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private View view;
    private LinearLayout ll_follow;
    private LinearLayout ll_empty_follow;
    private List<FollowBean> followList;
    private FollowAdapter mAdapter;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_follow,container,false);
        mRecyclerView = view.findViewById(R.id.rv_follow);
        ll_follow = view.findViewById(R.id.ll_follow);
        ll_empty_follow = view.findViewById(R.id.ll_empty_follow);
        //设置为线性布局排列
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);


        return view;
    }

    /**
     * 判断是否显示empty页面
     */
    private void isShow() {
        if(followList.size()>0&& followList!=null){
            ll_empty_follow.setVisibility(View.GONE);
            ll_follow.setVisibility(View.VISIBLE);

            //设置适配器
            mAdapter = new FollowAdapter(getContext(),followList);
            mAdapter.setItemListener(new FollowAdapter.OnItemClickListener() {
                @Override
                public void onClick(View view, int position) {
                    Intent intent = new Intent(getContext(),FollowDetailActivity.class);
                    intent.putExtra("isFollowed",true);
                    startActivity(intent);
                }
            });
            mRecyclerView.setAdapter(mAdapter);
        }else {
            ll_follow.setVisibility(View.GONE);
            ll_empty_follow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        isShow();
    }

    @Override
    public void initData() {
        followList = new ArrayList<>();
        initFollows();
    }

    private void initFollows() {
        for(int i =0 ;i<2;i++){
            FollowBean follow1 = new FollowBean(1,"","赌神一号","赌神一号：无视赔半，4.6.2.1，每周2，4...","加拿大");
            followList.add(follow1);
            FollowBean follow2 = new FollowBean(1,"","赌神二号","赌神一号：无视赔半，4.6.2.1，每周2，4...","加拿大");
            followList.add(follow2);
            FollowBean follow3 = new FollowBean(1,"","赌神三号","赌神一号：无视赔半，4.6.2.1，每周2，4...","加拿大");
            followList.add(follow3);
            FollowBean follow4 = new FollowBean(1,"","赌神四号","赌神一号：无视赔半，4.6.2.1，每周2，4...","加拿大");
            followList.add(follow4);
        }
    }

}
