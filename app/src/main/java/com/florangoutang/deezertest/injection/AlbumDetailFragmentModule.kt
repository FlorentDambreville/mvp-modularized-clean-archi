package com.florangoutang.deezertest.injection

import com.florangoutang.deezertest.ui.AlbumDetailFragment
import dagger.Module
import dagger.Provides

@Module
class AlbumDetailFragmentModule {

    @Provides
    fun provideFragment(): AlbumDetailFragment {
        return AlbumDetailFragment()
    }
}
