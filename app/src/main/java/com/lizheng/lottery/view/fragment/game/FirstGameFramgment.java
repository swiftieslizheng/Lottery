package com.lizheng.lottery.view.fragment.game;

import android.content.Context;
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

public class FirstGameFramgment extends BaseFragment {
    private GridView mGridView;
    private View view;
    private List<GameBean> mFirstGameList;
    private GridViewAdapter mAdapter;

    private FragmentInteraction listener;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_game_first,container,false);
        mGridView = view.findViewById(R.id.first_gridView);

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        mFirstGameList = new ArrayList<>();
        initListData();
        mAdapter = new GridViewAdapter(getContext(),mFirstGameList);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                for(int i = 0;i<mFirstGameList.size();i++){
                    if(position == i){
                        mFirstGameList.get(i).setSelect(true);
                    }else{
                        mFirstGameList.get(i).setSelect(false);
                    }
                }
                mAdapter.notifyDataSetChanged();
                listener.OnFirstGameItemClick(position);
            }
        });
    }

    private void initListData() {
        for (int i = 0; i < 2; i++) {
            GameBean game1 = new GameBean("1", "1:600.0", false);
            mFirstGameList.add(game1);
            GameBean game2 = new GameBean("2", "1:600.0", false);
            mFirstGameList.add(game2);
            GameBean game3 = new GameBean("3", "1:600.0", false);
            mFirstGameList.add(game3);
            GameBean game4 = new GameBean("4", "1:600.0", false);
            mFirstGameList.add(game4);
            GameBean game5 = new GameBean("5", "1:600.0", false);
            mFirstGameList.add(game5);
        }
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
        void OnFirstGameItemClick(int position);
    }
}
