package com.lizheng.lottery.bean;

/**
 * Created by lizheng on 2018/3/16.
 */

public class FollowBean {
    private int followId;
    private String imagUrl;
    private String name_follow;
    private String content_follow;
    private String position_follow;

    public FollowBean(int followId, String imagUrl, String name_follow, String content_follow, String position_follow) {
        this.followId = followId;
        this.imagUrl = imagUrl;
        this.name_follow = name_follow;
        this.content_follow = content_follow;
        this.position_follow = position_follow;
    }

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public String getImagUrl() {
        return imagUrl;
    }

    public void setImagUrl(String imagUrl) {
        this.imagUrl = imagUrl;
    }

    public String getName_follow() {
        return name_follow;
    }

    public void setName_follow(String name_follow) {
        this.name_follow = name_follow;
    }

    public String getContent_follow() {
        return content_follow;
    }

    public void setContent_follow(String content_follow) {
        this.content_follow = content_follow;
    }

    public String getPosition_follow() {
        return position_follow;
    }

    public void setPosition_follow(String position_follow) {
        this.position_follow = position_follow;
    }
}
