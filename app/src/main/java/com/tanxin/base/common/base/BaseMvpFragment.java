package com.tanxin.base.common.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.tanxin.base.common.base.mvp.BaseMvpView;
import com.tanxin.base.common.base.mvp.BasePresenter;
import com.tanxin.base.common.base.mvp.PresenterDispatch;
import com.tanxin.base.common.base.mvp.PresenterProviders;

/**
 * @author TANXIN
 * @date 2018/8/1 
 */
 
 
public abstract class BaseMvpFragment <P extends BasePresenter> extends BaseFragment implements BaseMvpView {
    private PresenterProviders mPresenterProviders;
    private PresenterDispatch mPresenterDispatch;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenterProviders = PresenterProviders.inject(this);
        mPresenterDispatch = new PresenterDispatch(mPresenterProviders);

        mPresenterDispatch.attachView(getActivity(), this);
        mPresenterDispatch.onCreatePresenter(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
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
    public void onDestroyView() {
        super.onDestroyView();
        mPresenterDispatch.detachView();
    }

    @Override
    public void showError(String error) {
        ToastUtils.showShort(error);
    }
}
