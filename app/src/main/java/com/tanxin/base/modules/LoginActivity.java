package com.tanxin.base.modules;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.tanxin.base.R;
import com.tanxin.base.common.base.BaseActivity;
import com.tanxin.base.common.base.BaseEvent;

import butterknife.BindView;

@Route(path = "/test/login")
public class LoginActivity extends BaseActivity {
    @Autowired
    public String key;

    @BindView(R.id.tv)
    TextView tv;

    public static void startActivity(String key){
        ARouter.getInstance().build("/test/login").withString("key",key).navigation();
    }

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
