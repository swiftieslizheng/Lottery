package com.lizheng.lottery.base;

import com.lizheng.lottery.model.IModel;
import com.lizheng.lottery.utils.RetrofitFactory;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lizheng on 2018/3/14.
 */

public abstract class BaseModel implements IModel{
    /**
     * 设置线程的切换
     */
    public <T>ObservableTransformer<T,T> setThread(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()) // 在IO线程进行网络请求
                        .observeOn(AndroidSchedulers.mainThread()); // 回到主线程 处理请求结果
            }
        };
    }
    /**
     * 创建Service
     */
    public <T> T createService(Class<T> service){

        checkService(service);

        return RetrofitFactory.getService(service);
    }

    /**
     * 检验参数Service
     * @param service
     * @param <T>
     */
    private <T> void checkService(Class<T> service) {
        if (service==null)
            throw new NullPointerException("service must not be null!");
        if (!service.isInterface())
            throw new IllegalArgumentException("Class must be interface !");
        if (service.getInterfaces().length>0)
            throw new IllegalArgumentException("service interfaces must not extends other interface!");

    }
}
