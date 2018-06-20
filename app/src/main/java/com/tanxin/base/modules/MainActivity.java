package com.tanxin.base.modules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.tanxin.base.R;
import com.tanxin.base.common.base.BaseActivity;
import com.tanxin.base.common.base.BaseEvent;
import com.tanxin.base.common.util.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.tab_view)
    BottomNavigationView tabView;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onEventComing(BaseEvent event) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Utils.disableShiftMode(tabView);
        tabView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_one:
                        ToastUtils.showShort("1");
                        break;
                    case R.id.menu_two:
                        ToastUtils.showShort("2");
                        break;
                    case R.id.menu_three:
                        ToastUtils.showShort("3");
                        break;
                    case R.id.menu_four:
                        ToastUtils.showShort("4");
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }


}
