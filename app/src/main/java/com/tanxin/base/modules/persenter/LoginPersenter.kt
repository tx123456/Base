package com.tanxin.base.modules.persenter

import com.tanxin.base.common.base.mvp.BasePresenter
import com.tanxin.base.modules.view.LoginView

/**
 * @author TANXIN
 * @date 2018/8/1
 */


class LoginPersenter : BasePresenter<LoginView>() {
    fun login() {
        mView?.loginSuccess()
    }
}
