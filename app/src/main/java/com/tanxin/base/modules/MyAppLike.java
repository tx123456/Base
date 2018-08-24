package com.tanxin.base.modules;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.meituan.android.walle.WalleChannelReader;
import com.tanxin.base.R;
import com.tanxin.base.common.api.Constant;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.tinker.loader.app.DefaultApplicationLike;

/**
 * @author TANXIN
 * @date 2018/6/20/020 
 */

@SuppressLint("StaticFieldLeak")
public class MyAppLike extends DefaultApplicationLike {
    private static Context context;

    public MyAppLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag,
                     long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplication();
        Utils.init(context);
        initBugly();

        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(getApplication());

        String channel = WalleChannelReader.getChannel(context);
    }

    private void initBugly() {
        /**
         * 自动初始化开关
         * true表示app启动自动初始化升级模块; false不会自动初始化; 开发者如果担心sdk初始化影响app启动速度，
         * 可以设置为false，在后面某个时刻手动调用Beta.init(getApplicationContext(),false);
         * */
        Beta.autoInit = true;
        /**
         * 自动检查更新开关
         * true表示初始化时自动检查升级; false表示不会自动检查升级,需要手动调用Beta.checkUpgrade()方法;
         * */
        Beta.autoCheckUpgrade = true;

        /**
         * 升级检查周期设置
         * 设置启动延时为1s（默认延时3s），APP启动1s后初始化SDK，避免影响APP启动速度;
         * */
        Beta.initDelay = 1000;

        /**
         * 设置通知栏大图标
         * largeIconId为项目中的图片资源;
         * */
        Beta.largeIconId = R.mipmap.ic_launcher;

        /**
         * 设置状态栏小图标
         * largeIconId为项目中的图片资源;
         * */
        Beta.smallIconId = R.mipmap.ic_launcher;

        /**
         * 设置更新弹窗默认展示的banner
         * defaultBannerId为项目中的图片资源Id; 当后台配置的banner拉取失败时显示此banner，
         * 默认不设置则展示“loading...“;*/
        Beta.defaultBannerId = R.mipmap.ic_launcher;

        /**
         * 设置sd卡的Download为更新资源存储目录
         * 后续更新资源会保存在此目录，需要在manifest中添加WRITE_EXTERNAL_STORAGE权限;*/
        Beta.storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        /*
        * 设置开启显示打断策略
        * 设置点击过确认的弹窗在App下次启动自动检查更新时会再次显示。
        * **/
        Beta.showInterruptedStrategy = true;

        /*
        * 添加可显示弹窗的Activity
        * 例如，只允许在MainActivity上显示更新弹窗，其他activity上不显示弹窗; 如果不设置默认所有activity都可以显示弹窗。**/
        Beta.canShowUpgradeActs.add(MainActivity.class);

        /*
        * 设置是否显示消息通知
        * 如果你不想在通知栏显示下载进度，你可以将这个接口设置为false，默认值为true。
        * **/
        Beta.enableNotification = true;

         /*
        * 设置Wifi下自动下载
        * 如果你想在Wifi网络下自动下载，可以将这个接口设置为true，默认值为false。
        * **/
        Beta.autoDownloadOnWifi = false;

        /*
        * 设置是否显示弹窗中的apk信息
        * 如果你使用我们默认弹窗是会显示apk信息的，如果你不想显示可以将这个接口设置为false**/
        Beta.canShowApkInfo = true;

        /*
        * 关闭热更新能力**/
        Beta.enableHotfix = true;

        // 设置是否自动下载补丁
        Beta.canAutoDownloadPatch = true;

        // 设置是否提示用户重启
        Beta.canNotifyUserRestart = true;

        // 设置是否自动合成补丁
        Beta.canAutoPatch = true;

        // 获取当前包名
        String packageName = context.getPackageName();
        // 获取当前进程名
        String processName = com.tanxin.base.common.util.Utils.getProcessName(android.os.Process.myPid());
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        // 初始化Bugly
        Bugly.init(context, Constant.KEY_BUGLY, false);
    }

    //返回
    public static Context getAppContext(){
        return context;
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        // 安装tinker
        // TinkerManager.installTinker(this); 替换成下面Bugly提供的方法
        Beta.installTinker(this);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallback(Application.ActivityLifecycleCallbacks callbacks) {
        getApplication().registerActivityLifecycleCallbacks(callbacks);
    }

}
