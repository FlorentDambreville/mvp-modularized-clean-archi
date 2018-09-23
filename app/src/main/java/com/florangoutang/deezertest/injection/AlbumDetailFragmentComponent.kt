package com.florangoutang.deezertest.injection

import com.florangoutang.deezertest.ui.AlbumDetailFragment
import com.florangoutang.deezertest.ui.AlbumListFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [AlbumDetailFragmentModule::class])
interface AlbumDetailFragmentComponent : AndroidInjector<AlbumDetailFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<AlbumDetailFragment>()
}