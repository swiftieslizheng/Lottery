package com.lizheng.lottery.view.fragment.game;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseFragment;
import com.lizheng.lottery.bean.GameBean;
import com.lizheng.lottery.view.adapter.GridViewAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizheng on 2018/3/24.
 */

public class ThirdGameFragment extends BaseFragment{
    private View view;
    private GridView mGridView;
    private List<GameBean> mThirdGameList;
    private GridViewAdapter mAdapter;
    private FragmentInteraction listener;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_game_third,container,false);

        mGridView = view.findViewById(R.id.third_gridView);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        mThirdGameList = new ArrayList<>();
        initListData();
        mAdapter = new GridViewAdapter(getContext(),mThirdGameList);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                for(int i = 0;i<mThirdGameList.size();i++){
                    if(position == i){
                        mThirdGameList.get(i).setSelect(true);
                    }else{
                        mThirdGameList.get(i).setSelect(false);
                    }
                }
                mAdapter.notifyDataSetChanged();
                listener.OnThirdGameItemClick(position);
            }
        });
    }

    private void initListData() {
        GameBean game1 = new GameBean("红", "1:3.0", false);
        mThirdGameList.add(game1);
        GameBean game2 = new GameBean("绿", "1:3.0", false);
        mThirdGameList.add(game2);
        GameBean game3 = new GameBean("蓝", "1:3.0", false);
        mThirdGameList.add(game3);
        GameBean game4 = new GameBean("豹子", "1:3.0", false);
        mThirdGameList.add(game4);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentInteraction){
            listener = (FragmentInteraction)context;
        }else{
            throw new IllegalArgumentException("activity must implements FragmentInteraction");
        }
    }

    public interface FragmentInteraction{
        void OnThirdGameItemClick(int position);
    }

}
