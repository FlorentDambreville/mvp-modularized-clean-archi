package com.florangoutang.deezertest.interfaceadapter

import com.florangoutang.deezertest.interfaceadapter.base.BasePresenter
import com.florangoutang.deezertest.interfaceadapter.base.BaseView
import com.florangoutang.deezertest.interfaceadapter.model.AlbumViewModel

interface AlbumListContract {

    interface View : BaseView {
        fun showAlbumListError(message: String?)
        fun showLoading(visible: Boolean)
        fun showAlbumList(list: MutableList<AlbumViewModel>)
    }

    interface Presenter : BasePresenter<View> {
        fun getAlbumList(offset: Int = 0)
        fun getNextAlbumListIfNecessary(positionInList: Int, itemCount: Int)
    }
}