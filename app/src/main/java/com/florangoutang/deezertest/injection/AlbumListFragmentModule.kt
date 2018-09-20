package com.florangoutang.deezertest.injection

import com.florangoutang.deezertest.interfaceadapter.AlbumListContract
import com.florangoutang.deezertest.interfaceadapter.AlbumListPresenterImpl
import com.florangoutang.deezertest.ui.AlbumListFragment
import dagger.Module
import dagger.Provides


@Module
class AlbumListFragmentModule {

    @Provides
    fun provideFragment() : AlbumListFragment {
        return AlbumListFragment()
    }

    @Provides
    fun provideAlbumListPresenter() : AlbumListContract.Presenter {
        return AlbumListPresenterImpl()
    }
}
