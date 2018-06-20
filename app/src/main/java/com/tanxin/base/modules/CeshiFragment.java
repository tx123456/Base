package com.tanxin.base.modules;


import android.app.Fragment;
import android.os.Bundle;
import android.widget.TextView;

import com.tanxin.base.R;
import com.tanxin.base.common.base.BaseEvent;
import com.tanxin.base.common.base.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CeshiFragment extends BaseFragment {


    @BindView(R.id.tv)
    TextView tv;

    public static CeshiFragment newInstance(String s) {

        Bundle args = new Bundle();
        args.putString("sss", s);
        CeshiFragment fragment = new CeshiFragment();
        fragment.setArguments(args);
        return fragment;
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
        tv.setText(getArguments().getString("sss"));
    }

}
