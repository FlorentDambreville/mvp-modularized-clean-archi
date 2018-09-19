package com.florangoutang.deezertest.injection


import com.florangoutang.deezertest.interfaceadapter.AlbumListContract
import com.florangoutang.deezertest.interfaceadapter.AlbumListPresenterImpl
import dagger.Module
import dagger.Provides


@Module
abstract class AlbumListModule {

    @Provides
    fun profiveAlbumListPresenter() : AlbumListContract.Presenter {
        return AlbumListPresenterImpl()
    }
}
