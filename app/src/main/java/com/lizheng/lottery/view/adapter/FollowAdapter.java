package com.lizheng.lottery.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.bean.FollowBean;

import java.util.List;

/**
 * Created by lizheng on 2018/3/16.
 */

public class FollowAdapter extends RecyclerView.Adapter<FollowAdapter.ViewHolder> {
    private Context mContext;
    private View view;
    private ViewHolder holder;
    private List<FollowBean> mFollowList;
    private OnItemClickListener mListener;

    public FollowAdapter(Context context, List<FollowBean> followList) {
        this.mContext = context;
        this.mFollowList = followList;
    }
    public void setItemListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }
    @Override
    public FollowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_follow_item,parent,false);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final FollowAdapter.ViewHolder holder, final int position) {
        FollowBean followBean = mFollowList.get(position);
        holder.name_follow.setText(followBean.getName_follow());
        holder.position_follow.setText(followBean.getPosition_follow());
        holder.content_follow.setText(followBean.getContent_follow());
        holder.followView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(view,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mFollowList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View followView;
        TextView name_follow;
        TextView content_follow;
        TextView position_follow;
        ImageView head_follow;

        public ViewHolder(View itemView) {
            super(itemView);
            followView = itemView;
            name_follow = itemView.findViewById(R.id.tv_name);
            content_follow = itemView.findViewById(R.id.tv_follow_content);
            position_follow = itemView.findViewById(R.id.tv_follow_position);
            head_follow = itemView.findViewById(R.id.iv_head_follow);

        }
    }

    public interface OnItemClickListener{
        //view点击的回调
        void onClick(View view,int position);
    }
}
