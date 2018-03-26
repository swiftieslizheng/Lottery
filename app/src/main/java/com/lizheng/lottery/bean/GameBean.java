package com.lizheng.lottery.bean;

/**
 * Created by lizheng on 2018/3/25.
 */

public class GameBean {
private String firstNum;
private String secondNum;
private boolean isSelect;

    public GameBean(String firstNum, String secondNum, boolean isSelect) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.isSelect = isSelect;
    }

    public String getFirstNum() {
        return firstNum;
    }

    public String getSecondNum() {
        return secondNum;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
