package com.tanxin.base.modules.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tanxin.base.R;
import com.tanxin.base.common.api.Constant;
import com.tanxin.base.common.base.BaseEvent;
import com.tanxin.base.common.base.BaseTitleMvpActivity;
import com.tanxin.base.common.base.mvp.CreatePresenter;
import com.tanxin.base.modules.persenter.LoginPersenter;
import com.tanxin.base.modules.view.LoginView;
import com.xiaomai.environmentswitcher.EnvironmentSwitchActivity;
import com.xiaomai.environmentswitcher.EnvironmentSwitcher;

import butterknife.BindView;

@Route(path = "/test/login")
@CreatePresenter(presenter = LoginPersenter.class)
public class LoginActivity extends BaseTitleMvpActivity<LoginPersenter> implements LoginView {
    @Autowired
    public String key;

    @BindView(R.id.tv)
    TextView tv;

//    @PresenterVariable
//    LoginPersenter loginPersenter;
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
        super.initView(savedInstanceState);
        tv.setText(key);
        qmuiTopBar.setTitle("登陆");
        getPresenter().login();

    }

    @Override
    public void loginSuccess() {
        String url = EnvironmentSwitcher.getAppEnvironment(getContext(), Constant.IS_DEBUG);
        EnvironmentSwitchActivity.launch(getContext());
    }
}
