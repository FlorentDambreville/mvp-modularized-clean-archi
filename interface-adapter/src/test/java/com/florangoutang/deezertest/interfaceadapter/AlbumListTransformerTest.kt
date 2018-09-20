package com.florangoutang.deezertest.interfaceadapter

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.model.AlbumRemoteModel
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class AlbumListTransformerTest {

    private val albumListTransformer = AlbumListTransformer()

    @Test
    fun `transform when expected remote model is valid should return albumList with same data as remote model`() {
        // Given
        val albumData = mock<AlbumRemoteModel.AlbumData> {
            on { id } doReturn 123
            on { title } doReturn "title"
            on { coverUrl } doReturn "deezer are the best"
        }
        val albumRemote = mock<AlbumRemoteModel> {
            on { data } doReturn listOf(albumData)
        }

        // When
        val albumList = albumListTransformer.albumRemoteToAlbumList(albumRemote)

        // Then
        assertThat(albumList.size).isEqualTo(1)
        assertThat(albumList[0]).isEqualTo(Album(123, "deezer are the best"))

    }
}