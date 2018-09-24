package com.florangoutang.deezertest.data

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.album.detail.AlbumDetailTransformer
import com.florangoutang.deezertest.usecase.album.detail.AlbumDetailDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class AlbumDetailDataSourceImpl @Inject constructor(val transformer : AlbumDetailTransformer) : AlbumDetailDataSource {

    private val albumRetrofitDataSource: AlbumRetrofitDataSource  by lazy { AlbumRetrofitDataSource.AlbumRetrofitApiBuilder().getDeezerApi() }

    override fun getAlbumDetail(albumId: Int): Flowable<Album> {
        return albumRetrofitDataSource.fetchAlbumDetail(albumId).map { transformer.albumRemoteToAlbum(it) }
    }
}