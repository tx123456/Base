package com.tanxin.base.modules.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.blankj.utilcode.util.ToastUtils
import com.tanxin.base.R
import com.tanxin.base.common.base.BaseEvent
import com.tanxin.base.modules.CeshiActivity
import com.tanxin.base.newCommon.base.BaseActivity
import kotlinx.android.synthetic.main.activity_aroute.*
import org.jetbrains.anko.startActivity


class ArouteActivity : BaseActivity() {
    var key:String ?=null
    override fun bindLayout(): Int {
        return R.layout.activity_aroute
    }

    override fun getBundleExtras(extras: Bundle) {
        key = extras.getString("key")
    }

    override fun onEventComing(event: BaseEvent<*>) {

    }

    override fun initView(savedInstanceState: Bundle?) {
        ToastUtils.showShort(key)
        tv.text = key
        startActivity<CeshiActivity>()
    }

    companion object {
        fun startActivity(context:Context,key: String) {
            context.startActivity(Intent(context, ArouteActivity::class.java).putExtra("key", key))
        }
    }
}
