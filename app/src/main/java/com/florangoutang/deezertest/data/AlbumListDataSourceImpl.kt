package com.florangoutang.deezertest.data

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.album.list.AlbumListTransformer
import com.florangoutang.deezertest.usecase.album.list.AlbumListDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class AlbumListDataSourceImpl @Inject constructor(val listTransformer : AlbumListTransformer) : AlbumListDataSource {

    private val albumRetrofitDataSource: AlbumRetrofitDataSource  by lazy { AlbumRetrofitDataSource.AlbumRetrofitApiBuilder().getDeezerApi() }

    override fun getAlbumList(offset: Int): Flowable<List<Album>> {
        return albumRetrofitDataSource.fetchAlbumList(offset).map { listTransformer.albumRemoteToAlbumList(it) }
    }
}