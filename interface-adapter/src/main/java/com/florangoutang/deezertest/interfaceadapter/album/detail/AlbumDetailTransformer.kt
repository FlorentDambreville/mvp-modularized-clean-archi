package com.florangoutang.deezertest.interfaceadapter.album.detail

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.album.detail.model.AlbumDetailRemoteModel
import com.florangoutang.deezertest.interfaceadapter.album.detail.model.AlbumDetailViewModel
import com.florangoutang.deezertest.interfaceadapter.util.emptyOrValue
import com.florangoutang.deezertest.interfaceadapter.util.zeroOrValue

class AlbumDetailTransformer {
    fun albumRemoteToAlbum(albumListRemoteModel: AlbumDetailRemoteModel): List<Album> {
        val albumList = mutableListOf<Album>()
        albumListRemoteModel.data.forEach { albumList.add(Album(it?.id.zeroOrValue(), it?.coverUrl.emptyOrValue())) }
        return albumList
    }

    fun albumToAlbumDetailViewModel(album: Album): AlbumDetailViewModel {
        with(album) {
            return AlbumDetailViewModel(id, coverUrl)
        }
    }
}