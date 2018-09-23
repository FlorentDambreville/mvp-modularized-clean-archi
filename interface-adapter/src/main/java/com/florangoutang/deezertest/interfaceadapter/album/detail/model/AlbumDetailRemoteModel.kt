package com.florangoutang.deezertest.interfaceadapter.album.detail.model

import com.google.gson.annotations.SerializedName

data class AlbumDetailRemoteModel(val data : List<AlbumData?>) {

    data class AlbumData(val id: Int?,
                         val title: String?,
                         @SerializedName("cover_medium") val coverUrl: String?, val artist: AlbumArtist?) {

        data class AlbumArtist(val id: Int?, val name: String?, val pictureUrl: String?)
    }
}

