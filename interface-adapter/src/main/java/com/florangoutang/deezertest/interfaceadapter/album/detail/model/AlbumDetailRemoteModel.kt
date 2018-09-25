package com.florangoutang.deezertest.interfaceadapter.album.detail.model

import com.florangoutang.deezertest.interfaceadapter.util.emptyOrValue
import com.google.gson.annotations.SerializedName

data class AlbumDetailRemoteModel(val id: Int?,
                                  val title: String?,
                                  @SerializedName("cover_big") val coverUrl: String?,
                                  val artist: AlbumArtist?,
                                  val tracks: Tracks?) {

    data class AlbumArtist(val id: Int?, val name: String?, val pictureUrl: String?)

    data class Tracks(val data: List<Track>?) {

        data class Track(val title: String?) {

            override fun toString(): String {
                return title.emptyOrValue()
            }

        }

    }

}

