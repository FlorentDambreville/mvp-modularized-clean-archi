package com.florangoutang.deezertest.interfaceadapter.model

data class AlbumRemoteModel(val data : List<AlbumData?>) {

    data class AlbumData(val id: Int?, val title: String?, val coverUrl: String?, val artist: AlbumArtist?) {

        data class AlbumArtist(val id: Int?, val name: String?, val pictureUrl: String?)
    }
}

