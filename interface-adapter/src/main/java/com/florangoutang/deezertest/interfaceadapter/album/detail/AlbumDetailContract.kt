package com.florangoutang.deezertest.interfaceadapter.album.detail

import com.florangoutang.deezertest.interfaceadapter.album.detail.model.AlbumDetailViewModel
import com.florangoutang.deezertest.interfaceadapter.base.BasePresenter
import com.florangoutang.deezertest.interfaceadapter.base.BaseView

interface AlbumDetailContract {

    interface View : BaseView {
        fun albumDetailError(message: String?)
        fun showLoading(visible: Boolean)
        fun showAlbumDetail(list: AlbumDetailViewModel)
    }

    interface Presenter : BasePresenter<View> {
        fun getAlbumDetail(albumId: Int)
    }
}