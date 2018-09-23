package com.florangoutang.deezertest.injection

import com.florangoutang.deezertest.data.AlbumListDataSourceImpl
import com.florangoutang.deezertest.interfaceadapter.album.list.AlbumListContract
import com.florangoutang.deezertest.interfaceadapter.album.list.AlbumListPresenterImpl
import com.florangoutang.deezertest.interfaceadapter.album.list.AlbumListTransformer
import com.florangoutang.deezertest.interfaceadapter.util.scheduler.BaseSchedulerProvider
import com.florangoutang.deezertest.interfaceadapter.util.scheduler.SchedulerProvider
import com.florangoutang.deezertest.ui.AlbumListFragment
import com.florangoutang.deezertest.usecase.album.list.AlbumListDataSource
import com.florangoutang.deezertest.usecase.album.list.AlbumListInteractor
import com.florangoutang.deezertest.usecase.album.list.AlbumListInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AlbumListFragmentModule {

    @Provides
    fun provideFragment() : AlbumListFragment {
        return AlbumListFragment()
    }

    @Provides
    fun provideAlbumListPresenter(interactor: AlbumListInteractor,
                                  listTransformer: AlbumListTransformer,
                                  schedulerProvider: BaseSchedulerProvider) : AlbumListContract.Presenter {
        return AlbumListPresenterImpl(interactor, listTransformer, schedulerProvider)
    }

    @Singleton
    @Provides
    fun provideBaseSchedulerProvider() : BaseSchedulerProvider {
        return SchedulerProvider()
    }

    @Provides
    fun provideAlbumListInteractor(dataSource: AlbumListDataSource) : AlbumListInteractor {
        return AlbumListInteractorImpl(dataSource)
    }

    @Provides
    fun provideAlbumListDataSource(listTransformer: AlbumListTransformer) : AlbumListDataSource {
        return AlbumListDataSourceImpl(listTransformer)
    }

    @Provides
    fun provideAlbumListTransformer() : AlbumListTransformer {
        return AlbumListTransformer()
    }
}
