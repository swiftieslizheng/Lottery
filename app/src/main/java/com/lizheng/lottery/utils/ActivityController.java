package com.lizheng.lottery.utils;

import com.lizheng.lottery.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizheng on 2018/3/13.
 */

public class ActivityController {
    private static List<BaseActivity> mBaseActivitys = new ArrayList<>();

    /**
     * 添加activity进入容器
     * @param activity
     */
    public static void addActivity(BaseActivity activity){
        mBaseActivitys.add(activity);
    }
    public static void removeActivity(BaseActivity activity){
        mBaseActivitys.remove(activity);
    }
    public static void clearActivity(){
        for(BaseActivity activity : mBaseActivitys){
            activity.finish();
        }
        mBaseActivitys.clear();
    }

}
