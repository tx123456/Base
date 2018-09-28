package com.tanxin.base.newCommon.interceptor

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.blankj.utilcode.util.LogUtils
import com.tanxin.base.modules.activity.LoginActivity

/**
 * Created by tanxin on 2018/9/28.
 */
@Interceptor(priority = 1)
class LoginInterceptor :IInterceptor{
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        if (postcard?.getPath() == "/test/activity") {
            callback?.onInterrupt(RuntimeException("进行登录拦截"))
            LogUtils.i(LoginInterceptor::class.java.name + "进行了拦截处理")
            LoginActivity.startActivity("拦截")
        }
    }

    override fun init(context: Context?) {
    }

}