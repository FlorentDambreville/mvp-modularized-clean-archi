package com.florangoutang.deezertest.usecase.album.list

import com.florangoutang.deezertest.entity.Album
import io.reactivex.Flowable

interface AlbumListDataSource {
    fun getAlbumList(offset: Int): Flowable<List<Album>>
}