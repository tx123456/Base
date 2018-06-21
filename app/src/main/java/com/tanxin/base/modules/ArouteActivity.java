package com.tanxin.base.modules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.tanxin.base.R;
import com.tanxin.base.common.base.BaseActivity;
import com.tanxin.base.common.base.BaseEvent;

import butterknife.BindView;

@Route(path = "/test/activity")
public class ArouteActivity extends BaseActivity {
    @Autowired
    public String key;

    @BindView(R.id.tv)
    TextView tv;


    @Override
    protected int bindLayout() {
        return R.layout.activity_aroute;
    }

    @Override
    protected void onEventComing(BaseEvent event) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ToastUtils.showShort(key);
        tv.setText(key);
    }
}
