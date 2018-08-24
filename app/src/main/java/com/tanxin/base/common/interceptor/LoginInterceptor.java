package com.tanxin.base.common.interceptor;
import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.blankj.utilcode.util.LogUtils;
import com.tanxin.base.modules.activity.LoginActivity;

/**
 * @author TANXIN
 * @date 2018/6/22/022 
 */


@Interceptor(priority = 1)
public class LoginInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (postcard.getPath().equals("/test/activity")){
            callback.onInterrupt(new RuntimeException("进行登录拦截"));
            LogUtils.i(LoginInterceptor.class.getName()+"进行了拦截处理");
            LoginActivity.startActivity("拦截");
        }
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {

    }
}
