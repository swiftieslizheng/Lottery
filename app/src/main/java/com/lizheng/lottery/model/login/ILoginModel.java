package com.lizheng.lottery.model.login;

import com.lizheng.lottery.base.BaseBean;
import com.lizheng.lottery.base.BaseObserver;
import com.lizheng.lottery.entity.LoginBean;
import com.lizheng.lottery.model.IModel;

import java.util.List;

/**
 * Created by Xie on 2018/3/14.
 */

public interface ILoginModel extends IModel {

    BaseObserver<BaseBean<List<LoginBean>>> getLoginImage(String imgUrl);
}
