package com.florangoutang.deezertest.usecase.album.list

import com.florangoutang.deezertest.entity.Album
import io.reactivex.Flowable

interface AlbumListInteractor {
    fun getAlbumList(offset: Int): Flowable<List<Album>>
}

class AlbumListInteractorImpl(private val dataSource: AlbumListDataSource) : AlbumListInteractor {
    override fun getAlbumList(offset: Int): Flowable<List<Album>> {
        return dataSource.getAlbumList(offset)
    }

}