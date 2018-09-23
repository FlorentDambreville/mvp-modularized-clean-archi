package com.florangoutang.deezertest.interfaceadapter.album.list

import com.florangoutang.deezertest.interfaceadapter.base.BasePresenter
import com.florangoutang.deezertest.interfaceadapter.base.BaseView
import com.florangoutang.deezertest.interfaceadapter.album.list.model.AlbumListViewModel

interface AlbumListContract {

    interface View : BaseView {
        fun showAlbumListError(message: String?)
        fun showLoading(visible: Boolean)
        fun showAlbumList(list: MutableList<AlbumListViewModel>)
        fun addToAlbumList(list: MutableList<AlbumListViewModel>)
    }

    interface Presenter : BasePresenter<View> {
        fun getAlbumList(offset: Int = 0, reInitList: Boolean = false)
        fun getNextAlbumListIfNecessary(positionInList: Int, itemCount: Int)
    }
}