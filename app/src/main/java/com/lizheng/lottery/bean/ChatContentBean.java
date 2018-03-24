package com.lizheng.lottery.bean;

/**
 * Created by lizheng on 2018/3/23.
 * 聊天列表类
 */

public class ChatContentBean {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;
    private String imgurl;
    private int uId;
    private String content;
    private int type;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public ChatContentBean(String imgurl, int uId, String content, int type, String date) {
        this.imgurl = imgurl;
        this.uId = uId;
        this.content = content;
        this.type = type;
        this.date = date;
    }

    public ChatContentBean(String content, int type, String date) {
        this.content = content;
        this.type = type;
        this.date = date;
    }

    public String getImgurl() {
        return imgurl;
    }

    public int getuId() {
        return uId;
    }

    public String getContent() {
        return content;
    }

}
