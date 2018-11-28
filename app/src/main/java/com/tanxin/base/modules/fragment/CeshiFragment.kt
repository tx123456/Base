package com.tanxin.base.modules.fragment


import android.os.Bundle

import com.tanxin.base.R
import com.tanxin.base.common.api.Constant
import com.tanxin.base.common.base.BaseEvent
import com.tanxin.base.common.base.BaseMvpFragment
import com.tanxin.base.common.base.mvp.CreatePresenter
import com.tanxin.base.modules.activity.LoginActivity
import com.tanxin.base.modules.persenter.LoginPersenter
import com.tanxin.base.modules.view.LoginView
import com.xiaomai.environmentswitcher.EnvironmentSwitchActivity
import com.xiaomai.environmentswitcher.EnvironmentSwitcher
import kotlinx.android.synthetic.main.fragment_ceshi.*
import org.jetbrains.anko.sdk27.coroutines.onClick

@CreatePresenter(presenter = [(LoginPersenter::class)])
class CeshiFragment : BaseMvpFragment<LoginPersenter>(), LoginView {


    var key: String? = null

    override fun getContentViewId(): Int = R.layout.fragment_ceshi

    override fun onEventComing(event: BaseEvent<*>) {

    }

    override fun initView() {
        tv.text = key
        tv.onClick {
//            if (key == "ONE") {
//                LoginActivity.startActivity(_mActivity, "ONE")
//            } else {
//                LoginActivity.startActivity(_mActivity, "ONEa")
//            }
            val url = EnvironmentSwitcher.getAppEnvironment(getThisContext(),Constant.IS_DEBUG)
            EnvironmentSwitchActivity.launch(getThisContext())
        }
        getPresenter().login()
    }

    override fun loginSuccess() {
        showError("loh")
    }

    companion object {
        fun newInstance(key: String): CeshiFragment {
            val args = Bundle()
            args.putString("key", key)
            val fragment = CeshiFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
