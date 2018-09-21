package com.florangoutang.deezertest.interfaceadapter

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.model.AlbumRemoteModel
import com.florangoutang.deezertest.interfaceadapter.model.AlbumViewModel

class AlbumListTransformer {
    fun albumRemoteToAlbumList(albumRemoteModel: AlbumRemoteModel): List<Album> {
        val albumList = mutableListOf<Album>()
        albumRemoteModel.data.forEach { albumList.add(Album(it?.id.zeroOrValue(), it?.coverUrl.emptyOrValue())) }
        return albumList
    }

    fun albumToAlbumViewModel(album: Album) : AlbumViewModel {
        with(album) {
            return AlbumViewModel(id, coverUrl)
        }
    }
}

fun Int?.zeroOrValue() : Int {
    return when(this) {
        null -> 0
        else -> this
    }
}

fun String?.emptyOrValue() : String {
    return when(this) {
        null -> ""
        else -> this
    }
}