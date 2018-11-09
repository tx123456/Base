package com.tanxin.base.modules

import android.os.Bundle
import com.tanxin.base.R
import com.tanxin.base.R.id.tab_view
import com.tanxin.base.common.base.BaseEvent
import com.tanxin.base.common.base.BaseFragment
import com.tanxin.base.modules.fragment.CeshiFragment
import com.tanxin.base.newCommon.base.BaseActivity
import com.tanxin.base.newCommon.util.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val one:Int = 0
    private val two:Int = 1
    private val three:Int = 2
    private val four:Int = 3


    private val mFragments = arrayOfNulls<BaseFragment>(4)
    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    override fun getBundleExtras(extras: Bundle) {

    }

    override fun onEventComing(event: BaseEvent<*>) {
    }

    override fun initView(savedInstanceState: Bundle?) {
        val borrowFragment = findFragment(CeshiFragment::class.java)
        if (borrowFragment == null) {
            mFragments[one] = CeshiFragment.newInstance("ONE")
            mFragments[two] = CeshiFragment.newInstance("TWO")
            mFragments[three] = CeshiFragment.newInstance("THREE")
            mFragments[four] = CeshiFragment.newInstance("FOUR")
            loadMultipleRootFragment(R.id.main_container, one,
                    mFragments[one], mFragments[two], mFragments[three], mFragments[four])
        } else {
            mFragments[one] = borrowFragment
            mFragments[two] = findFragment(CeshiFragment::class.java)
            mFragments[three] = findFragment(CeshiFragment::class.java)
            mFragments[four] = findFragment(CeshiFragment::class.java)
        }
        Utils.disableShiftMode(tab_view)
        tab_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_one -> showHideFragment(mFragments[one])
                R.id.menu_two -> showHideFragment(mFragments[two])
                R.id.menu_three -> showHideFragment(mFragments[three])
                R.id.menu_four -> showHideFragment(mFragments[four])
            }
            true
        }
    }


}
