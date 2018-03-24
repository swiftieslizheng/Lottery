package com.lizheng.lottery.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lizheng.lottery.R;

/**
 * Created by lizheng on 2018/3/17.
 * 底部对话框BottomDialog弹出
 */

public class ButtomDialog extends Dialog {
    private TextView tv_protest;
    private TextView tv_dismiss;
    private OnProtestClickListener mOnProtestListener;
    private OnDismissClickListener mOnDismissListener;


    public ButtomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_content,null);
        setContentView(view);
        tv_protest = findViewById(R.id.tv_protest);
        tv_dismiss = findViewById(R.id.tv_dismiss);
        tv_protest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnProtestListener.onClick(view);
            }
        });
        tv_dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnDismissListener.onClick(view);
            }
        });
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = getContext().getResources().getDisplayMetrics().widthPixels;
        view.setLayoutParams(layoutParams);
        setCanceledOnTouchOutside(true);
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
    }

    public void setOnProtestClickListener(OnProtestClickListener mListener){
        this.mOnProtestListener = mListener;
    }
    public void setOnDismissClickListener(OnDismissClickListener mListener){
        this.mOnDismissListener= mListener;
    }
    public interface OnProtestClickListener{
       void  onClick(View view);
    }
    public interface OnDismissClickListener{
        void  onClick(View view);
    }
}
