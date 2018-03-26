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

public class SecondGameFragment extends BaseFragment {
    private View view;
    private GridView mGridView;
    private List<GameBean> mSecondGameList;
    private GridViewAdapter mAdapter;
    private FragmentInteraction listener;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_game_second,container,false);

        mGridView = view.findViewById(R.id.second_gridView);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        mSecondGameList = new ArrayList<>();
        initListData();
        mAdapter = new GridViewAdapter(getContext(),mSecondGameList);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                for(int i = 0;i<mSecondGameList.size();i++){
                    if(position == i){
                        mSecondGameList.get(i).setSelect(true);
                    }else{
                        mSecondGameList.get(i).setSelect(false);
                    }
                }
                mAdapter.notifyDataSetChanged();
                listener.OnSecondGameItemClick(position);
            }
        });
    }
    private void initListData() {
        for (int i = 0; i < 2; i++) {
            GameBean game1 = new GameBean("大", "1:20.0", false);
            mSecondGameList.add(game1);
            GameBean game2 = new GameBean("小", "1:20.0", false);
            mSecondGameList.add(game2);
            GameBean game3 = new GameBean("单", "1:20.0", false);
            mSecondGameList.add(game3);
            GameBean game4 = new GameBean("双", "1:20.0", false);
            mSecondGameList.add(game4);
            GameBean game5 = new GameBean("大单", "1:20.0", false);
            mSecondGameList.add(game5);
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
        void OnSecondGameItemClick(int position);
    }
}
