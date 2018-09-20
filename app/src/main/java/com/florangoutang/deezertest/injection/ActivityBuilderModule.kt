package com.florangoutang.deezertest.injection

import android.app.Activity
import dagger.multibindings.IntoMap
import dagger.Binds
import com.florangoutang.deezertest.ui.MainActivity
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector


@Module
abstract class ActivityBuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindMainActivity(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

}