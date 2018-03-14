package com.lizheng.lottery.base;

import com.lizheng.lottery.presenter.IPresenter;
import com.lizheng.lottery.view.IView;

/**
 * Created by lizheng on 2018/3/14.
 */

public abstract class BasePresenter<T extends IView> implements IPresenter<T> {
    protected T mView;


    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        if(this.mView!= null){
            mView = null;
        }
    }

    @Override
    public T getView() {
        return this.mView;
    }
}
