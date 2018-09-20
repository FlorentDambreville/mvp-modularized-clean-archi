package com.florangoutang.deezertest.injection

import android.support.v4.app.Fragment
import com.florangoutang.deezertest.ui.AlbumListFragment
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey


@Module
abstract class FragmentBuilderModule {

    @Binds
    @IntoMap
    @FragmentKey(AlbumListFragment::class)
    internal abstract fun bindMainActivity(builder: AlbumListFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>

}