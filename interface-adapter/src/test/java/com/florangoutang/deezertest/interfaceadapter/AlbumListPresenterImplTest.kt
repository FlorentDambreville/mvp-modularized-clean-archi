package com.florangoutang.deezertest.interfaceadapter

import com.florangoutang.deezertest.interfaceadapter.util.TestSchedulerProvider
import com.florangoutang.deezertest.interfaceadapter.util.scheduler.BaseSchedulerProvider
import com.florangoutang.deezertest.usecase.AlbumListInteractor
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.then
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AlbumListPresenterImplTest {

    @InjectMocks lateinit var presenter: AlbumListPresenterImpl
    @Mock lateinit var transformer: AlbumListTransformer
    @Mock lateinit var interactor: AlbumListInteractor
    @Mock lateinit var schedulerProvider: BaseSchedulerProvider
    @Mock lateinit var view: AlbumListContract.View
    private val testSchedulers = TestSchedulerProvider()

    @Before
    fun setUp() {
        presenter.attachView(view)
        given(schedulerProvider.computation()).willReturn(testSchedulers.computation())
        given(schedulerProvider.ui()).willReturn(testSchedulers.ui())
    }

    @Test
    fun `getNextAlbumListIfNecessary when last list item is charged should call getAlbumList`() {
        // Given
        given(interactor.getAlbumList(25)).willReturn(Flowable.just(listOf()))

        // When
        presenter.getNextAlbumListIfNecessary(24, 25)
        testSchedulers.computation().triggerActions()

        // Then
        presenter.getAlbumList(25)
    }

    @Test
    fun `getNextAlbumListIfNecessary when very last list item in API is charged should NOT call getAlbumList`() {
        // Given
        val objectReturnFromAPI = 17
        given(interactor.getAlbumList(25)).willReturn(Flowable.just(listOf()))

        // When
        presenter.getNextAlbumListIfNecessary(49, 50)
        testSchedulers.computation().triggerActions()

        // Then do nothing
    }

    @Test
    fun `getAlbumList should show loading and then call interactor`() {
        // Given
        given(interactor.getAlbumList(25)).willReturn(Flowable.just(listOf()))

        // When
        presenter.getAlbumList( 25)
        testSchedulers.computation().triggerActions()

        // Then
        inOrder(view, interactor) {
            then(view).should().showLoading(true)
            then(interactor).should().getAlbumList(25)
        }
    }
}