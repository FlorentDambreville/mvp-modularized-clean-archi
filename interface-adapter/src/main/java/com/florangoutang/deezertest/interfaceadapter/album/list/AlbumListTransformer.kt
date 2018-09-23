package com.florangoutang.deezertest.interfaceadapter.album.list

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.album.list.model.AlbumListRemoteModel
import com.florangoutang.deezertest.interfaceadapter.album.list.model.AlbumListViewModel
import com.florangoutang.deezertest.interfaceadapter.util.emptyOrValue
import com.florangoutang.deezertest.interfaceadapter.util.zeroOrValue

class AlbumListTransformer {
    fun albumRemoteToAlbumList(albumListRemoteModel: AlbumListRemoteModel): List<Album> {
        val albumList = mutableListOf<Album>()
        albumListRemoteModel.data.forEach { albumList.add(Album(it?.id.zeroOrValue(), it?.coverUrl.emptyOrValue())) }
        return albumList
    }

    fun albumToAlbumListViewModel(album: Album) : AlbumListViewModel {
        with(album) {
            return AlbumListViewModel(id, coverUrl)
        }
    }
}