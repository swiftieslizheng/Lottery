package com.lizheng.lottery.presenter;

import com.lizheng.lottery.view.IView;

/**
 * Created by lizheng on 2018/3/14.
 */

public interface IPresenter<T extends IView> {
    /**
     * 获取View
     */
   void attachView(T view);
    /**
     * 解绑View
     */
   void detachView();
    /**
     * 获取View
     */
    T getView();
}
