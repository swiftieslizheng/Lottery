package com.lizheng.lottery.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lizheng.lottery.R;
import com.lizheng.lottery.bean.ChatContentBean;
import com.lizheng.lottery.utils.FilterUtil;
import com.lizheng.lottery.utils.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizheng on 2018/3/23.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHodler> {
    private Context mContext;
    private List<ChatContentBean> mChatContentList;

    public ChatAdapter(List<ChatContentBean> mChatContentList, Context context) {
        this.mChatContentList = mChatContentList;
        this.mContext = context;
    }


    @Override
    public ChatAdapter.ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,parent,false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHodler holder, int position) {
        ChatContentBean chatContent = mChatContentList.get(position);
        if(chatContent.getType() == ChatContentBean.TYPE_RECEIVED){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftDate.setText(chatContent.getDate());
            Glide.with(mContext).load(chatContent.getImgurl()).into(holder.iv_left);
//            holder.leftContent.setText(chatContent.getContent());
            disPlayLeftTextView(holder,chatContent);

        }else if(chatContent.getType() == ChatContentBean.TYPE_SEND){
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightDate.setText(chatContent.getDate());
            Glide.with(mContext).load(chatContent.getImgurl()).into(holder.iv_right);
//            holder.rightContent.setText(chatContent.getContent());
             disPlayRightTextView(holder,chatContent);
        }
    }

    /**
     * 利用spannable对表情进行转码显示
     * @param holder
     * @param bean
     */
    public void disPlayLeftTextView(ViewHodler holder, ChatContentBean bean) {
        setContent(holder.leftContent, bean.getContent());
    }
    public void disPlayRightTextView(ViewHodler holder, ChatContentBean bean) {
        setContent(holder.rightContent, bean.getContent());
    }
    public void setContent(TextView tv_content, String content) {
        FilterUtil.spannableEmoticonFilter(tv_content, content);
    }

    @Override
    public int getItemCount() {
        return mChatContentList.size();
    }

    static class ViewHodler extends RecyclerView.ViewHolder{
        RelativeLayout leftLayout;
        RelativeLayout rightLayout;
        ImageView iv_left;
        ImageView iv_right;
        TextView leftDate;
        TextView rightDate;
        TextView leftContent;
        TextView rightContent;
        public ViewHodler(View itemView) {
            super(itemView);
            leftLayout = itemView.findViewById(R.id.rl_left);
            rightLayout = itemView.findViewById(R.id.rl_right);
            iv_left = itemView.findViewById(R.id.chat_head_sculpture_left);
            iv_right = itemView.findViewById(R.id.chat_head_sculpture_right);
            leftDate  =itemView.findViewById(R.id.txt_date_left);
            rightDate  =itemView.findViewById(R.id.txt_date_right);
            leftContent = itemView.findViewById(R.id.txt_chat_content_left);
            rightContent = itemView.findViewById(R.id.txt_chat_content_right);

        }
    }
}
