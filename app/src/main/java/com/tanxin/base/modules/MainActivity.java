package com.tanxin.base.modules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.tanxin.base.R;
import com.tanxin.base.common.base.BaseActivity;
import com.tanxin.base.common.base.BaseEvent;
import com.tanxin.base.common.base.BaseTitleActivity;
import com.tencent.bugly.crashreport.CrashReport;

public class MainActivity extends BaseActivity {


    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onEventComing(BaseEvent event) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
    }
}
