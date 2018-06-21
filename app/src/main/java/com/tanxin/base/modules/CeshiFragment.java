package com.tanxin.base.modules;


import android.app.Fragment;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
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
    }

}
