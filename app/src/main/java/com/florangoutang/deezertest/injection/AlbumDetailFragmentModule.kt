package com.florangoutang.deezertest.injection

import com.florangoutang.deezertest.data.AlbumDetailDataSourceImpl
import com.florangoutang.deezertest.interfaceadapter.album.detail.AlbumDetailContract
import com.florangoutang.deezertest.interfaceadapter.album.detail.AlbumDetailPresenterImpl
import com.florangoutang.deezertest.interfaceadapter.album.detail.AlbumDetailTransformer
import com.florangoutang.deezertest.interfaceadapter.util.scheduler.BaseSchedulerProvider
import com.florangoutang.deezertest.interfaceadapter.util.scheduler.SchedulerProvider
import com.florangoutang.deezertest.ui.AlbumDetailFragment
import com.florangoutang.deezertest.usecase.album.detail.AlbumDetailDataSource
import com.florangoutang.deezertest.usecase.album.detail.AlbumDetailInteractor
import com.florangoutang.deezertest.usecase.album.detail.AlbumDetailInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AlbumDetailFragmentModule {

    @Provides
    fun provideFragment(): AlbumDetailFragment {
        return AlbumDetailFragment()
    }

    @Provides
    fun provideAlbumListPresenter(interactor: AlbumDetailInteractor,
                                  listTransformer: AlbumDetailTransformer,
                                  schedulerProvider: BaseSchedulerProvider) : AlbumDetailContract.Presenter {
        return AlbumDetailPresenterImpl(interactor, listTransformer, schedulerProvider)
    }

    @Singleton
    @Provides
    fun provideBaseSchedulerProvider() : BaseSchedulerProvider {
        return SchedulerProvider()
    }

    @Provides
    fun provideAlbumListInteractor(dataSource: AlbumDetailDataSource) : AlbumDetailInteractor {
        return AlbumDetailInteractorImpl(dataSource)
    }

    @Provides
    fun provideAlbumListDataSource(listTransformer: AlbumDetailTransformer) : AlbumDetailDataSource {
        return AlbumDetailDataSourceImpl(listTransformer)
    }

    @Provides
    fun provideAlbumListTransformer() : AlbumDetailTransformer {
        return AlbumDetailTransformer()
    }
}
