package com.florangoutang.deezertest.injection

import com.florangoutang.deezertest.data.AlbumListDataSourceImpl
import com.florangoutang.deezertest.data.AlbumListDataSourceImpl_Factory
import com.florangoutang.deezertest.interfaceadapter.AlbumListContract
import com.florangoutang.deezertest.interfaceadapter.AlbumListPresenterImpl
import com.florangoutang.deezertest.interfaceadapter.AlbumListTransformer
import com.florangoutang.deezertest.ui.AlbumListFragment
import com.florangoutang.deezertest.usecase.AlbumListDataSource
import com.florangoutang.deezertest.usecase.AlbumListInteractor
import com.florangoutang.deezertest.usecase.AlbumListInteractorImpl
import dagger.Module
import dagger.Provides


@Module
class AlbumListFragmentModule {

    @Provides
    fun provideFragment() : AlbumListFragment {
        return AlbumListFragment()
    }

    @Provides
    fun provideAlbumListPresenter(interactor: AlbumListInteractor, transformer: AlbumListTransformer) : AlbumListContract.Presenter {
        return AlbumListPresenterImpl(interactor, transformer)
    }

    @Provides
    fun provideAlbumListInteractor(dataSource: AlbumListDataSource) : AlbumListInteractor {
        return AlbumListInteractorImpl(dataSource)
    }

    @Provides
    fun provideAlbumListDataSource(transformer: AlbumListTransformer) : AlbumListDataSource {
        return AlbumListDataSourceImpl(transformer)
    }

    @Provides
    fun provideAlbumListTransformer() : AlbumListTransformer {
        return AlbumListTransformer()
    }
}
