package com.florangoutang.deezertest.interfaceadapter

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.usecase.AlbumListInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AlbumListPresenterImpl(val interactor: AlbumListInteractor, val transformer: AlbumListTransformer) : AlbumListContract.Presenter {

    override var view: AlbumListContract.View? = null

    private val subscriptions: CompositeDisposable = CompositeDisposable()

    override fun attachView(view: AlbumListContract.View?) {
        this.view = view
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun getAlbumList() {
        view?.showLoading(true)
        subscriptions.add(interactor.getAlbumList()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { view?.showLoading(false) }
                .subscribe({ albumList: List<Album> ->
                    view?.showAlbumList(albumList.map { transformer.albumToAlbumViewModel(it) }.toMutableList())
                },
                        { error: Throwable ->
                            error.printStackTrace()
                            view?.showAlbumListError(error.message)

                        }
                )
        )
    }

}