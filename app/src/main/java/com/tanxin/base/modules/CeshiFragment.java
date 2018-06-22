package com.tanxin.base.modules;


import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tanxin.base.R;
import com.tanxin.base.common.base.BaseEvent;
import com.tanxin.base.common.base.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
@Route(path = "/test/fragment")
public class CeshiFragment extends BaseFragment {


    @BindView(R.id.tv)
    TextView tv;
    @Autowired
    public String key;

    public static BaseFragment startFragment(String key){
        return (BaseFragment) ARouter.getInstance().build("/test/fragment").withString("key",key).navigation();
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_ceshi;
    }

    @Override
    protected void onEventComing(BaseEvent event) {

    }

    @Override
    protected void initView() {
        tv.setText(key);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (key.equals("ONE")){
                    LoginActivity.startActivity("login");
                }else {
                    ArouteActivity.startActivity("dssa");
                }

            }
        });
    }

}
