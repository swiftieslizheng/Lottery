package com.lizheng.lottery.utils;

import com.lizheng.lottery.global.GlobalContent;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lizheng on 2018/3/14.
 * 创建Service实例
 */

public class RetrofitFactory {
    private static Retrofit mRetrofit;

    private RetrofitFactory(){}

    public static <T> T getService(Class<T> service) {
        if (mRetrofit == null) {
            synchronized (RetrofitFactory.class) {
                if (mRetrofit == null) {
                    mRetrofit = new Retrofit.Builder()
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(GlobalContent.BASEURL)
                            .build();
                }
            }
        }
        return mRetrofit.create(service);
    }
}
