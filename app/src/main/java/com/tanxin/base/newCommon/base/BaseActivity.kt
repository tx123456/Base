package com.tanxin.base.newCommon.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ScreenUtils
import com.tanxin.base.common.base.BaseEvent
import me.yokeyword.fragmentation.SupportActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * Created by tanxin on 2018/9/28.
 * BaseActivity
 */
abstract class BaseActivity : SupportActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setWindow()
        setBaseView()
        LogUtils.i(javaClass.name)
        ARouter.getInstance().inject(this)
        EventBus.getDefault().register(this)
        if (ScreenUtils.isPortrait()) {
            ScreenUtils.adaptScreen4VerticalSlide(this, 360)
        } else {
            ScreenUtils.adaptScreen4HorizontalSlide(this, 360)
        }
        initView(savedInstanceState)
    }

    open fun setWindow(){
    }

    open fun setBaseView(){
        setContentView(LayoutInflater.from(this).inflate(bindLayout(), null))
    }

    /**
     * 获取布局资源
     * @return 布局资源
     */
    protected abstract fun bindLayout(): Int


    /**
     * EventBus接收消息
     * @param event 获取事件总线信息
     */
    protected abstract fun onEventComing(event: BaseEvent<*>)


    /**
     * 初始化界面
     * @param savedInstanceState savedInstanceState
     */
    protected abstract fun initView(savedInstanceState: Bundle?)

    /**
     * EventBus接收消息
     *
     * @param event 消息接收
     */
    @Subscribe
    fun onEventMainThread(event: BaseEvent<*>?) {
        if (null != event) {
            onEventComing(event)
        }
    }

    fun getContext(): Context {
        return this
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}