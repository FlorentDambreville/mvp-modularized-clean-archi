package com.florangoutang.deezertest.interfaceadapter.album.detail.model

data class AlbumDetailViewModel(val id: Int,
                                val coverUrl: String,
                                val title: String,
                                val artistName: String,
                                val songList: List<String>)