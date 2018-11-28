package com.tanxin.base.common.base.mvp

import java.util.HashMap

/**
 * create by lzx
 * time:2018/7/26
 */
class PresenterStore<P : BasePresenter<*>> {
    private val DEFAULT_KEY = "PresenterStore.DefaultKey"

    val map = HashMap<String, P>()



    fun put(key: String, presenter: P) {
        val oldPresenter = map.put("$DEFAULT_KEY:$key", presenter)
        oldPresenter?.onCleared()
    }

    operator fun get(key: String): P? {
        return map["$DEFAULT_KEY:$key"]
    }

    fun clear() {
        for (presenter in map.values) {
            presenter.onCleared()
        }
        map.clear()
    }

    fun getSize(): Int = map.size
}
