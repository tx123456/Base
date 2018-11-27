package com.tanxin.base.modules;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;
import com.meituan.android.walle.WalleChannelReader;
import com.tanxin.base.common.api.Constant;
import com.tencent.bugly.Bugly;


/**
 * @author TANXIN
 * @date 2018/6/20/020 
 */


public class MyApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        MultiDex.install(context);
        Utils.init(context);
        Bugly.init(getApplicationContext(), Constant.Companion.getKEY_BUGLY(), false);
        String channel = WalleChannelReader.getChannel(context);
    }

    //返回
    public static Context getAppContext(){
        return context;
    }

}
