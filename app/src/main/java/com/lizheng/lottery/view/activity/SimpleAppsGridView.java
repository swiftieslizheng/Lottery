package com.lizheng.lottery.view.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.lizheng.lottery.R;
import com.lizheng.lottery.bean.AppBean;
import com.lizheng.lottery.view.adapter.AppsAdapter;

import java.util.ArrayList;

/**
 * Created by lizheng on 2018/3/18.
 */

class SimpleAppsGridView extends RelativeLayout {
    protected View view;

    public SimpleAppsGridView(Context context) {
        this(context, null);
    }

    public SimpleAppsGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.view_apps, this);
        init();
    }

    protected void init(){
        GridView gv_apps = view.findViewById(R.id.gv_apps);
        ArrayList<AppBean> mAppBeanList = new ArrayList<>();
        mAppBeanList.add(new AppBean(R.mipmap.icon_photo, "相册"));
        mAppBeanList.add(new AppBean(R.mipmap.icon_camera, "拍摄"));
        mAppBeanList.add(new AppBean(R.mipmap.icon_photo, "上分"));
        mAppBeanList.add(new AppBean(R.mipmap.icon_camera, "下分"));
        AppsAdapter adapter = new AppsAdapter(getContext(), mAppBeanList);
        gv_apps.setAdapter(adapter);
    }
}
