package com.tanxin.base.common.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author TANXIN
 * @date 2018/7/31 
 */
 
 
public class BasePresenter <V>  {
    protected Context mContext;
    protected V mView;

    protected void onCleared() {

    }

    public void attachView(Context context, V view) {
        this.mContext = context;
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }

    public boolean isAttachView() {
        return this.mView != null;
    }

    public void onCreatePresenter(@Nullable Bundle savedState) {

    }

    public void onDestroyPresenter() {
        this.mContext = null;
        detachView();
    }

    public void onSaveInstanceState(Bundle outState) {

    }
}
