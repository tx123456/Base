package com.tanxin.base.common.base;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.blankj.utilcode.util.BarUtils;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.tanxin.base.R;
import com.tanxin.base.common.api.Constant;

/**
 * @author TANXIN
 * @date 2018/6/20/020 
 */
 
 
public abstract class BaseTitleActivity extends BaseActivity {
    protected QMUITopBar qmuiTopBar;
    FrameLayout activityContainer;

    @Override
    protected void setBaseView() {
        contentView = LayoutInflater.from(this).inflate(R.layout.base_title_activity, null);
        setContentView(contentView);
        activityContainer = findViewById(R.id.activity_container);
        qmuiTopBar = findViewById(R.id.qmui_topbar);
        activityContainer.addView(LayoutInflater.from(this).inflate(bindLayout(), activityContainer, false));

        BarUtils.setStatusBarColor(this, ContextCompat.getColor(getContext(), R.color.themeColor), Constant.DEFAULT_ALPHA);
        BarUtils.addMarginTopEqualStatusBarHeight(qmuiTopBar);
        qmuiTopBar.setBackgroundDividerEnabled(false);
        qmuiTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();
            }
        });
    }
}
