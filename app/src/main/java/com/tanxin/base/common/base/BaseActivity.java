package com.tanxin.base.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.tanxin.base.common.util.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author TANXIN
 * @date 2018/6/20/020 
 */
public abstract class BaseActivity extends SupportActivity{
    private Unbinder unbinder;
    protected View contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindow();
        setBaseView();
        LogUtils.i(getClass().getName());
        unbinder = ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
        EventBus.getDefault().register(this);
        if (ScreenUtils.isPortrait()) {
            ScreenUtils.adaptScreen4VerticalSlide(this, 360);
        } else {
            ScreenUtils.adaptScreen4HorizontalSlide(this, 360);
        }
        initView(savedInstanceState);
    }

    public void setWindow(){}

    protected void setBaseView() {
        setContentView(contentView = LayoutInflater.from(this).inflate(bindLayout(), null));
    }

    /**
     * 获取布局资源
     * @return 布局资源
     */
    protected abstract int bindLayout();


    /**
     * EventBus接收消息
     * @param event 获取事件总线信息
     */
    protected abstract void onEventComing(BaseEvent event);


    /**
     * 初始化界面
     * @param savedInstanceState savedInstanceState
     * */
    protected abstract void initView(Bundle savedInstanceState);



    /**
     * EventBus接收消息
     *
     * @param event 消息接收
     */
    @Subscribe
    public void onEventMainThread(BaseEvent event) {
        if (null != event) {
            onEventComing(event);
        }
    }

    public Context getContext(){
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑ButterKnife
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
