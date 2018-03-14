package com.lizheng.lottery.base;

import com.lizheng.lottery.global.GlobalContent;

/**
 * Created by lizheng on 2018/3/14.
 *  数据实体的基类
 */

public class BaseBean<T> {
    private int code;//返回码
    private String msg;//返回的信息
    private T data;//返回的数据
    /**
     * 判断是否请求码成功
     */
    public boolean isSuccess(){
        return this.code== GlobalContent.SUCCESS_CODE;
    }
    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
