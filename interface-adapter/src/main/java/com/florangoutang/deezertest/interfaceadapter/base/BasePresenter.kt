package com.florangoutang.deezertest.interfaceadapter.base

interface BasePresenter<V : BaseView> {

    var view : V?

    fun attachView(view : V?)

    fun detachView() {
        this.view = null
    }
    fun unsubscribe()
}