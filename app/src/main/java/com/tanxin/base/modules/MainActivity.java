package com.tanxin.base.modules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tanxin.base.R;
import com.tanxin.base.common.base.BaseActivity;
import com.tanxin.base.common.base.BaseEvent;
import com.tanxin.base.common.base.BaseFragment;
import com.tanxin.base.common.util.Utils;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.tab_view)
    BottomNavigationView tabView;

    public static final int ONE = 0;
    public static final int TWO = 1;
    public static final int THREE = 2;
    public static final int FOUR = 3;

    private BaseFragment[] mFragments = new BaseFragment[4];
    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onEventComing(BaseEvent event) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        BaseFragment borrowFragment = findFragment(CeshiFragment.class);
        if (borrowFragment == null) {
            mFragments[ONE] = (BaseFragment) ARouter.getInstance().build("/test/fragment")
                        .withString("key","ONE").navigation();
            mFragments[TWO] = (BaseFragment) ARouter.getInstance().build("/test/fragment")
                        .withString("key","TWO").navigation();
            mFragments[THREE] = (BaseFragment) ARouter.getInstance().build("/test/fragment")
                        .withString("key","THREE").navigation();
            mFragments[FOUR] = (BaseFragment) ARouter.getInstance().build("/test/fragment")
                        .withString("key","FOUR").navigation();
            loadMultipleRootFragment(R.id.main_container, ONE,
                    mFragments[ONE], mFragments[TWO], mFragments[THREE], mFragments[FOUR]);
        } else {
            mFragments[ONE] = borrowFragment;
            mFragments[TWO] = findFragment(CeshiFragment.class);
            mFragments[THREE] = findFragment(CeshiFragment.class);
            mFragments[FOUR] = findFragment(CeshiFragment.class);
        }
        Utils.disableShiftMode(tabView);
        tabView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_one:
                        showHideFragment(mFragments[ONE]);
                        break;
                    case R.id.menu_two:
                        showHideFragment(mFragments[TWO]);
                        break;
                    case R.id.menu_three:
                        showHideFragment(mFragments[THREE]);
                        break;
                    case R.id.menu_four:
                        showHideFragment(mFragments[FOUR]);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        ARouter.getInstance().build("/test/activity").withString("key","ddd").navigation();

    }


}
