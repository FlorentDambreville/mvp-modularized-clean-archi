package com.florangoutang.deezertest.entity

data class Album(val id: Int,
                 val coverUrl: String,
                 val title: String,
                 val artistName: String,
                 val songList: List<String>?)
