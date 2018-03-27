package com.lizheng.lottery.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.bean.TrendViewBean;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Xie on 2018/3/26.
 */

public class TrendViewAdapter extends RecyclerView.Adapter<TrendViewAdapter.ViewHolder> {

    private List<TrendViewBean> mList;
    private Context context;
    private ViewHolder holder;

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView ts_trend_time;
        TextView ts_trend_number;

        public ViewHolder(View itemView) {
            super(itemView);
            ts_trend_time = itemView.findViewById(R.id.ts_trend_time);
            ts_trend_number = itemView.findViewById(R.id.ts_trend_number);

        }
    }

    public TrendViewAdapter(List<TrendViewBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_trend_view_item,null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TrendViewBean bean = mList.get(position);
        holder.ts_trend_time.setText(bean.getTrend_time());
        holder.ts_trend_number.setText(bean.getTrend_number());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }
}
