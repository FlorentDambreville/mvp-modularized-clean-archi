package com.florangoutang.deezertest.interfaceadapter.album.detail

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.album.detail.model.AlbumDetailRemoteModel
import com.florangoutang.deezertest.interfaceadapter.album.detail.model.AlbumDetailViewModel
import com.florangoutang.deezertest.interfaceadapter.util.emptyOrValue
import com.florangoutang.deezertest.interfaceadapter.util.zeroOrValue

class AlbumDetailTransformer {
    fun albumRemoteToAlbum(albumDetailRemoteModel: AlbumDetailRemoteModel): Album {
        with(albumDetailRemoteModel) {
            val songList = mutableListOf<String>()
            tracks?.data?.forEach { songList.add(it.toString()) }
            return Album(id.zeroOrValue(),
                    coverUrl.emptyOrValue(),
                    title.emptyOrValue(),
                    artist?.name.emptyOrValue(),
                    songList)
        }
    }

    fun albumToAlbumDetailViewModel(album: Album): AlbumDetailViewModel {
        with(album) {
            return AlbumDetailViewModel(id, coverUrl, title, artistName, songList!!)
        }
    }
}