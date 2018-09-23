package com.florangoutang.deezertest.injection

import android.support.v4.app.Fragment
import com.florangoutang.deezertest.ui.AlbumDetailFragment
import com.florangoutang.deezertest.ui.AlbumListFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap


@Module
abstract class FragmentBuilderModule {

    @Binds
    @IntoMap
    @FragmentKey(AlbumListFragment::class)
    internal abstract fun bindMainActivityToAlbumListFragment(builder: AlbumListFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(AlbumDetailFragment::class)
    internal abstract fun bindMainActivityToAlbumDetailFragment(builder: AlbumDetailFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>

}