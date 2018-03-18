package com.lizheng.lottery.model.login;

import com.lizheng.lottery.base.BaseBean;
import com.lizheng.lottery.base.BaseModel;
import com.lizheng.lottery.base.BaseObserver;
import com.lizheng.lottery.entity.LoginBean;
import com.lizheng.lottery.service.LoginService;
import com.lizheng.lottery.view.activity.LoginActivity;

import java.util.List;

/**
 * Created by Xie on 2018/3/14.
 */

public class LoginModel extends BaseModel implements ILoginModel {

    LoginService mService = this.createService(LoginService.class);

    @Override
    public BaseObserver<BaseBean<List<LoginBean>>> getLoginImage(String imgUrl) {
        return mService.getLoginImage(imgUrl);
    }
}
