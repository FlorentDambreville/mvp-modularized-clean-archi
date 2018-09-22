package com.florangoutang.deezertest.injection

import com.florangoutang.deezertest.ui.AlbumListFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [AlbumListFragmentModule::class])
interface AlbumListFragmentComponent : AndroidInjector<AlbumListFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<AlbumListFragment>()
}