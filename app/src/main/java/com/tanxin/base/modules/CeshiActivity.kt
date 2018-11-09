package com.tanxin.base.modules

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import com.tanxin.base.R
import com.tanxin.base.common.base.BaseEvent
import com.tanxin.base.newCommon.base.BaseTitleActivity
import kotlinx.android.synthetic.main.base_title_activity.*
import kotlinx.android.synthetic.main.fragment_ceshi.*
import org.jetbrains.anko.toast

/**
 * Created by 阳阳 on 2018/9/28.
 */
class CeshiActivity :BaseTitleActivity(){

    override fun bindLayout(): Int {
        return R.layout.fragment_ceshi
    }

    override fun getBundleExtras(extras: Bundle) {

    }

    override fun onEventComing(event: BaseEvent<*>) {
    }

    override fun initView(savedInstanceState: Bundle?) {
        qmuiTopBar.setTitle("666666")
        tv.text="测试赛所所所"
        toast("ceshi")
    }



}