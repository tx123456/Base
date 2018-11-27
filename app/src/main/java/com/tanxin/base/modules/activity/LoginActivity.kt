package com.tanxin.base.modules.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.tanxin.base.R
import com.tanxin.base.common.base.BaseEvent
import com.tanxin.base.common.base.BaseTitleMvpActivity
import com.tanxin.base.common.base.mvp.CreatePresenter
import com.tanxin.base.modules.CeshiActivity
import com.tanxin.base.modules.persenter.LoginPersenter
import com.tanxin.base.modules.view.LoginView
import kotlinx.android.synthetic.main.activity_aroute.*
import kotlinx.android.synthetic.main.base_title_activity.*
import org.jetbrains.anko.startActivity

@CreatePresenter(presenter = [(LoginPersenter::class)])
class LoginActivity : BaseTitleMvpActivity<LoginPersenter>(), LoginView {

    var key: String? = null

    companion object {
        fun startActivity(context: Context, key: String) {
            context.startActivity(Intent(context, CeshiActivity::class.java).putExtra("key", key))
        }
    }

    override fun bindLayout(): Int = R.layout.activity_aroute

    override fun getBundleExtras(extras: Bundle) {
        key = extras.getString("key")
    }

    override fun onEventComing(event: BaseEvent<*>) {

    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        tv.text = key
        titleView.setTitle("登陆")
        presenter.login()

    }

    override fun loginSuccess() {
        startActivity<CeshiActivity>()

    }


}
