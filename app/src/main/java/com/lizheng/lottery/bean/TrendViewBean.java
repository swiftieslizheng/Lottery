package com.lizheng.lottery.bean;

/**
 * Created by Xie on 2018/3/26.
 */

public class TrendViewBean {
    private String trend_time;
    private String trend_number;

    public TrendViewBean(String trend_time, String trend_number) {
        this.trend_time = trend_time;
        this.trend_number = trend_number;
    }

    public String getTrend_time() {
        return trend_time;
    }

    public void setTrend_time(String trend_time) {
        this.trend_time = trend_time;
    }

    public String getTrend_number() {
        return trend_number;
    }

    public void setTrend_number(String trend_number) {
        this.trend_number = trend_number;
    }
}
