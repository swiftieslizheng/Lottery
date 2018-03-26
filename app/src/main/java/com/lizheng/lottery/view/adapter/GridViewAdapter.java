package com.lizheng.lottery.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.bean.GameBean;

import java.util.List;

/**
 * Created by lizheng on 2018/3/25.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<GameBean> gameList;



    public GridViewAdapter(Context mContext, List<GameBean> gameList) {
        this.mContext = mContext;
        this.gameList = gameList;
    }

    @Override
    public int getCount() {
        return gameList.size();
    }

    @Override
    public Object getItem(int i) {
        return gameList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final GameBean game = (GameBean) getItem(position);
        ViewHolder viewHolder;
        if(view == null){
            view = View.inflate(mContext, R.layout.item_game,null);
            viewHolder = new ViewHolder();
            viewHolder.ll_game = view.findViewById(R.id.ll_game);
            viewHolder.txt_first = view.findViewById(R.id.txt_num_one);
            viewHolder.txt_second = view.findViewById(R.id.txt_num_two);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if(game.isSelect()){
            viewHolder.ll_game.setBackgroundResource(R.drawable.item_game_background);
        }else {
            viewHolder.ll_game.setBackgroundResource(R.drawable.item_game_background_unselect);
        }
        viewHolder.txt_first.setText(game.getFirstNum());
        viewHolder.txt_second.setText(game.getSecondNum());

        return view;
    }
    class ViewHolder{
        LinearLayout ll_game;
         TextView txt_first;
         TextView txt_second;
    }
}
