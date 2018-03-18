package com.lizheng.lottery.service;

import com.lizheng.lottery.base.BaseBean;
import com.lizheng.lottery.base.BaseObserver;
import com.lizheng.lottery.entity.LoginBean;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Xie on 2018/3/14.
 */

public interface LoginService {

    @FormUrlEncoded
    @POST("/")
    BaseObserver<BaseBean<List<LoginBean>>> getLoginImage(@Field("/") String imgUrl);
}
