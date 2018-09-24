package com.florangoutang.deezertest.usecase.album.detail

import com.florangoutang.deezertest.entity.Album
import io.reactivex.Flowable

interface AlbumDetailDataSource {
    fun getAlbumDetail(albumId: Int): Flowable<Album>
}