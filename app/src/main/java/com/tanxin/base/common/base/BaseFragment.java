package com.tanxin.base.common.base;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tanxin.base.modules.MyAppLike;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;


/**
 * @author TANXIN
 * @date 2018/6/20/020 
 */
 
 
public abstract class BaseFragment extends SupportFragment {
    private Unbinder unbinder;
    protected View rootView;
    private Context mContext;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mContext = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        ARouter.getInstance().inject(this);
        setBaseView(inflater,container);
        unbinder = ButterKnife.bind(this,rootView);
        noLazy();
        return rootView;
    }

    protected  void setBaseView(LayoutInflater inflater, ViewGroup container){
        rootView = inflater.inflate(getContentViewId(),container,false);
    }

    @Override
    public Context getContext(){
        if (mContext==null){
            mContext = MyAppLike.getAppContext();
        }
        return mContext;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initView();
    }

    //不使用懒加载
    public void noLazy(){

    }

    public abstract int getContentViewId();


    /**
     * EventBus接收消息
     *
     * @param event 获取事件总线信息
     */
    protected abstract void onEventComing(BaseEvent event);

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

    protected abstract void initView();


    //设置动画
    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置默认Fragment动画  默认竖向(和安卓5.0以上的动画相同)
//        return super.onCreateFragmentAnimator();
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
        // 设置自定义动画
//        return new FragmentAnimator(enter,exit,popEnter,popExit);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
