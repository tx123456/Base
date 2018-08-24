package com.tanxin.base.modules.persenter;

import com.tanxin.base.common.base.mvp.BasePresenter;
import com.tanxin.base.modules.view.LoginView;

/**
 * @author TANXIN
 * @date 2018/8/1 
 */
 
 
public class LoginPersenter extends BasePresenter<LoginView> {
    public void login(){
        mView.loginSuccess();
    }
}
