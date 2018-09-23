package com.florangoutang.deezertest.usecase

import com.florangoutang.deezertest.usecase.album.list.AlbumListDataSource
import com.florangoutang.deezertest.usecase.album.list.AlbumListInteractorImpl
import com.nhaarman.mockitokotlin2.then
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AlbumListInteractorImplTest {

    @InjectMocks lateinit var interactor: AlbumListInteractorImpl
    @Mock lateinit var dataSource: AlbumListDataSource

    @Test
    fun `getAlbumList should call dataSource`() {
        // When
       interactor.getAlbumList(42)

        // Then
        then(dataSource).should().getAlbumList(42)
    }
}