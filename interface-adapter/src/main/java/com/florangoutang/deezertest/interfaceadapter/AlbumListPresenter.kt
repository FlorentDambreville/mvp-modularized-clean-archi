package com.florangoutang.deezertest.interfaceadapter

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.util.scheduler.BaseSchedulerProvider
import com.florangoutang.deezertest.usecase.AlbumListInteractor
import io.reactivex.disposables.CompositeDisposable

class AlbumListPresenterImpl(val interactor: AlbumListInteractor,
                             val transformer: AlbumListTransformer,
                             val schedulersProvider : BaseSchedulerProvider) : AlbumListContract.Presenter {

    override var view: AlbumListContract.View? = null

    private val subscriptions: CompositeDisposable = CompositeDisposable()
    private val errorThrowTransformProcessAuthorized = 2
    private val objectWantedFromTheAPI = 25 - errorThrowTransformProcessAuthorized
    private var objectReturnFromAPI = 0

    override fun attachView(view: AlbumListContract.View?) {
        this.view = view
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun getAlbumList(offset: Int) {
        view?.showLoading(true)
        subscriptions.add(interactor.getAlbumList(offset)
                .subscribeOn(schedulersProvider.computation())
                .observeOn(schedulersProvider.ui())
                .doFinally { view?.showLoading(false) }
                .subscribe({ albumList: List<Album> ->
                    view?.showAlbumList(albumList.map { transformer.albumToAlbumViewModel(it) }.toMutableList())
                    objectReturnFromAPI = albumList.size
                },
                        { error: Throwable ->
                            error.printStackTrace()
                            view?.showAlbumListError(error.message)

                        }
                )
        )
    }

    override fun getNextAlbumListIfNecessary(positionInList: Int, itemCount: Int) {
        if (!isTheEndOfTheApiReached() && positionInList == itemCount - 1) {
            getAlbumList(itemCount)
        }
    }

    private fun isTheEndOfTheApiReached() = objectReturnFromAPI < objectWantedFromTheAPI

}