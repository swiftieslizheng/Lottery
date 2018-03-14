package com.lizheng.lottery.base;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by lizheng on 2018/3/14.
 */

public abstract  class BaseObserver<T>  implements Observer<BaseBean<T>> {

    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }



    @Override
    public void onNext(BaseBean<T> tBaseBean) {
        onRequestEnd(true);
        onResultMsg(tBaseBean.getMsg());
        if(tBaseBean.isSuccess()){
            onSuccess(tBaseBean.getData());
        }else{
            onCodeError();
        }
    }



    @Override
    public void onError(Throwable e) {
        onRequestEnd(false);
        onFail(e);
    }



    @Override
    public void onComplete() {
        onRequestEnd(true);
    }


    /**
     * 请求结束
     */
    public void onRequestEnd(boolean isSuccess){}

    /**
     * 请求开始
     */
    public void onRequestStart(){}

    protected abstract void onFail(Throwable e);

    protected abstract void onSuccess(T data);
    /**
     * 失败返回码
     */
    public void onCodeError(){}
    /**
     * 请求返回信息
     */
    public void onResultMsg(String msg) {}
}
