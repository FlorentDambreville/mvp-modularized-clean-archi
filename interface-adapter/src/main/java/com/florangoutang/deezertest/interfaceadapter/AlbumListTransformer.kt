package com.florangoutang.deezertest.interfaceadapter

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.model.AlbumRemoteModel
import com.florangoutang.deezertest.interfaceadapter.model.AlbumViewModel

class AlbumListTransformer {
    fun albumRemoteToAlbumList(albumRemoteModel: AlbumRemoteModel): List<Album> {
        val albumList = mutableListOf<Album>()
        albumRemoteModel.data.forEach { albumList.add(Album(it.id, it.coverUrl)) }
        return albumList
    }

    fun albumToAlbumViewModel(album: Album) : AlbumViewModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}