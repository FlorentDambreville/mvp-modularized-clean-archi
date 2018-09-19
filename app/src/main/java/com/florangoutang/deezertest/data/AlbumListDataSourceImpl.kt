package com.florangoutang.deezertest.data

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.AlbumListTransformer
import com.florangoutang.deezertest.usecase.AlbumListDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class AlbumListDataSourceImpl @Inject constructor(val transformer : AlbumListTransformer) : AlbumListDataSource {

    private val albumListRetrofitDataSource: AlbumListRetrofitDataSource  by lazy { AlbumListRetrofitDataSource.AlbumRetrofitApiBuilder().getDeezerApi() }

    override fun getAlbumList(): Flowable<List<Album>> {
        return albumListRetrofitDataSource.fetchAlbumList().map { transformer.albumRemoteToAlbumList(it) }
    }
}