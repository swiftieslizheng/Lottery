package com.lizheng.lottery.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lizheng.lottery.R;

/**
 * Created by Xie on 2018/3/25.
 */

public class TrendImgAdapter extends BaseAdapter {
    private String data[]=null;
    private Context context;
    private int i;//取代position的容器
    private final int TEXT_SIZE = 11;
    private int img[] = {R.color.colorYellow,R.color.colorBulueTop,R.color.colorBulueMiddle,R.color.colorBulueButtom};

    public TrendImgAdapter(String[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    static class Holder{
        LinearLayout lin_trend;
        TextView ts_trend_img;

        public void setLin_trend(LinearLayout lin_trend) {
            this.lin_trend = lin_trend;
        }

        public void setTs_trend_img(TextView ts_trend_img) {
            this.ts_trend_img = ts_trend_img;
        }
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Holder holder;
        view = View.inflate(context, R.layout.activity_trend_img_item,null);
        holder = new Holder();
        holder.lin_trend = view.findViewById(R.id.lin_trend);
        holder.ts_trend_img = view.findViewById(R.id.ts_trend_img);
        view.setTag("TAG");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        params.height = 60;
        holder.ts_trend_img.setText(data[position]);
        i = position;
        if (i < 10) {
            holder.lin_trend.setBackgroundResource(img[0]);
            params.height = 100;
        }

        if (i>=10) {
            if (i %10 == 0) {
                params.weight = 1;
                holder.ts_trend_img.setTextSize(TEXT_SIZE);
            }
            if ((i-1)%5 == 0) {
                holder.ts_trend_img.setBackgroundResource(img[2]);
            }
        }


        view.setLayoutParams(params);

        return view;

    }
}
