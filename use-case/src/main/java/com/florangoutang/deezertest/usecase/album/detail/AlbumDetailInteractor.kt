package com.florangoutang.deezertest.usecase.album.detail

import com.florangoutang.deezertest.entity.Album
import io.reactivex.Flowable

interface AlbumDetailInteractor {
    fun getAlbumDetail(albumId: Int): Flowable<Album>
}

class AlbumDetailInteractorImpl(private val dataSource: AlbumDetailDataSource) : AlbumDetailInteractor {
    override fun getAlbumDetail(albumId: Int): Flowable<Album> {
        return dataSource.getAlbumDetail(albumId)
    }

}