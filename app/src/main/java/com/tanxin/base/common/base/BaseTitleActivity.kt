package com.tanxin.base.common.base

import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import com.blankj.utilcode.util.BarUtils
import com.tanxin.base.R
import com.tanxin.base.common.api.Constant
import kotlinx.android.synthetic.main.base_title_activity.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * Created by tanxin on 2018/9/28.
 */
abstract class BaseTitleActivity : BaseActivity() {

    final override fun setBaseView() {
        setContentView(LayoutInflater.from(this).inflate(R.layout.base_title_activity, null))

        activityContainer.addView(LayoutInflater.from(this).inflate(bindLayout(), activityContainer, false))

        BarUtils.setStatusBarColor(this, ContextCompat.getColor(getThisContext(), R.color.themeColor), Constant.DEFAULT_ALPHA)
        BarUtils.addMarginTopEqualStatusBarHeight(titleView)
        titleView.setBackgroundDividerEnabled(false)
        titleView.addLeftBackImageButton().onClick {
            onBackPressedSupport()
        }
    }
}