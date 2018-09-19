package com.florangoutang.deezertest.usecase

import com.florangoutang.deezertest.entity.Album
import io.reactivex.Flowable

interface AlbumListInteractor {
    fun getAlbumList(): Flowable<List<Album>>
}

class AlbumListInteractorImpl(private val dataSource: AlbumListDataSource) : AlbumListInteractor {
    override fun getAlbumList(): Flowable<List<Album>> {
        return dataSource.getAlbumList()
    }

}