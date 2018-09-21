package com.florangoutang.deezertest.usecase

import com.florangoutang.deezertest.entity.Album
import io.reactivex.Flowable

interface AlbumListDataSource {
    fun getAlbumList(offset: Int): Flowable<List<Album>>
}