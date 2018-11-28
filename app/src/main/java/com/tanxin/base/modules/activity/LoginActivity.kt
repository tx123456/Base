package com.tanxin.base.modules.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.tanxin.base.R
import com.tanxin.base.common.base.BaseEvent
import com.tanxin.base.common.base.BaseTitleMvpActivity
import com.tanxin.base.common.base.mvp.CreatePresenter
import com.tanxin.base.modules.persenter.LoginPersenter
import com.tanxin.base.modules.view.LoginView
import kotlinx.android.synthetic.main.base_title_activity.*
import kotlinx.android.synthetic.main.fragment_ceshi.*
import org.jetbrains.anko.toast

@CreatePresenter(presenter = [(LoginPersenter::class)])
class LoginActivity : BaseTitleMvpActivity<LoginPersenter>(), LoginView {

    var key: String = ""

    companion object {
        fun startActivity(context: Context, key: String) {
            context.startActivity(Intent(context, LoginActivity::class.java).putExtra("key", key))
        }
    }

    override fun bindLayout(): Int = R.layout.fragment_ceshi

    override fun getBundleExtras(extras: Bundle) {
        key = extras.getString("key","")
    }

    override fun onEventComing(event: BaseEvent<*>) {

    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        tv.text = key
        titleView.setTitle("登陆")
        getPresenter().login()

    }

    override fun loginSuccess() {
        toast(key)
    }


}
