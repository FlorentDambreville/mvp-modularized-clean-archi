package com.florangoutang.deezertest.interfaceadapter.album.detail

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.album.list.AlbumListTransformer
import com.florangoutang.deezertest.interfaceadapter.util.scheduler.BaseSchedulerProvider
import com.florangoutang.deezertest.usecase.album.detail.AlbumDetailInteractor
import io.reactivex.disposables.CompositeDisposable

class AlbumDetailPresenterImpl(val interactor: AlbumDetailInteractor,
                               val listTransformer: AlbumDetailTransformer,
                               val schedulersProvider : BaseSchedulerProvider) : AlbumDetailContract.Presenter {

    override var view: AlbumDetailContract.View? = null

    private val subscriptions: CompositeDisposable = CompositeDisposable()

    override fun attachView(view: AlbumDetailContract.View?) {
        this.view = view
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun getAlbumDetail(albumId: Int) {
        view?.showLoading(true)
        subscriptions.add(interactor.getAlbumDetail()
                .subscribeOn(schedulersProvider.computation())
                .observeOn(schedulersProvider.ui())
                .doFinally { view?.showLoading(false) }
                .subscribe({ albumList: List<Album> ->
                    view?.showSongList(albumList.map { listTransformer.albumToAlbumDetailViewModel(it) }.toMutableList())
                },
                        { error: Throwable ->
                            error.printStackTrace()
                            view?.showSongListError(error.message)

                        }
                )
        )
    }

}