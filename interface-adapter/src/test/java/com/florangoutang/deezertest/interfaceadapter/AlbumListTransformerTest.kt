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
    fun `albumRemoteToAlbumList when expected remote model is valid should return albumList with same data as remote model`() {
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

    @Test
    fun `albumRemoteToAlbumList when empty remote model should return empty albumList`() {
        // Given
        val albumRemote = mock<AlbumRemoteModel>()

        // When
        val albumList = albumListTransformer.albumRemoteToAlbumList(albumRemote)

        // Then
        assertThat(albumList.size).isEqualTo(0)
    }

    @Test
    fun `albumRemoteToAlbumList when invalid remote model return albumList with default`() {
        // Given
        val albumData = mock<AlbumRemoteModel.AlbumData>()
        val albumRemote = mock<AlbumRemoteModel> {
            on { data } doReturn listOf(albumData)
        }

        // When
        val albumList = albumListTransformer.albumRemoteToAlbumList(albumRemote)

        // Then
        assertThat(albumList.size).isEqualTo(1)
        assertThat(albumList[0]).isEqualTo(Album(0, ""))
    }

    @Test
    fun `albumToAlbumViewModel when empty remote model should return empty albumList`() {
        // Given
        val album = mock<Album> {
            on { id } doReturn 42
            on { coverUrl } doReturn "coverUrl"
        }

        // When
        val albumViewModel = albumListTransformer.albumToAlbumViewModel(album)

        // Then
        assertThat(albumViewModel.id).isEqualTo(42)
        assertThat(albumViewModel.coverUrl).isEqualTo("coverUrl")
    }
}