package com.tanxin.base.modules;

import com.tanxin.base.common.base.mvp.BasePresenter;

/**
 * @author TANXIN
 * @date 2018/8/1 
 */
 
 
public class LoginPersenter extends BasePresenter<LoginView> {
    public void login(){
        mView.loginSuccess();
    }
}
