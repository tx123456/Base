package com.tanxin.base.common.base;

import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.tanxin.base.common.base.mvp.BaseMvpView;
import com.tanxin.base.common.base.mvp.BasePresenter;
import com.tanxin.base.common.base.mvp.PresenterDispatch;
import com.tanxin.base.common.base.mvp.PresenterProviders;
import com.tanxin.base.newCommon.base.*;

/**
 * @author TANXIN
 * @date 2018/8/1 
 */
 
 
public abstract class BaseTitleMvpActivity <P extends BasePresenter> extends com.tanxin.base.newCommon.base.BaseTitleActivity
            implements BaseMvpView {
    private PresenterProviders mPresenterProviders;
    private PresenterDispatch mPresenterDispatch;

    @Override
    protected void initView(Bundle savedInstanceState) {
        mPresenterProviders = PresenterProviders.inject(this);
        mPresenterDispatch = new PresenterDispatch(mPresenterProviders);

        mPresenterDispatch.attachView(this, this);
        mPresenterDispatch.onCreatePresenter(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenterDispatch.onSaveInstanceState(outState);
    }

    protected P getPresenter() {
        return mPresenterProviders.getPresenter(0);
    }

    public PresenterProviders getPresenterProviders() {
        return mPresenterProviders;
    }


    @Override
    public void showError(String error) {
        ToastUtils.showShort(error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenterDispatch.detachView();
    }
}
