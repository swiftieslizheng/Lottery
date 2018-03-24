package com.lizheng.lottery.bean;

/**
 * Created by lizheng on 2018/3/18.
 */

public class TestBean {
private TestBean(){

}
private static TestBean instance= new TestBean();
    public static TestBean getInstance(){
        return instance;
    }
}

