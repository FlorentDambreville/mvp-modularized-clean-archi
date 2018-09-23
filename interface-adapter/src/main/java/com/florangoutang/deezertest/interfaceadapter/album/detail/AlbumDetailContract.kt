package com.florangoutang.deezertest.interfaceadapter.album.detail

import com.florangoutang.deezertest.interfaceadapter.base.BasePresenter
import com.florangoutang.deezertest.interfaceadapter.base.BaseView
import com.florangoutang.deezertest.interfaceadapter.album.list.model.AlbumListViewModel

interface AlbumDetailContract {

    interface View : BaseView {
        fun showSongListError(message: String?)
        fun showLoading(visible: Boolean)
        fun showSongList(list: MutableList<AlbumListViewModel>)
    }

    interface Presenter : BasePresenter<View> {
        fun getAlbumDetail(albumId: Int)
    }
}