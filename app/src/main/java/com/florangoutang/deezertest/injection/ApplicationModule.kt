package com.florangoutang.deezertest.injection

import android.app.Application
import android.content.Context
import com.florangoutang.deezertest.ui.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MainActivityComponent::class, AlbumListFragmentComponent::class])
class ApplicationModule {
    @Provides
    @Singleton
    internal fun provideApplicationContext(application: Application) = application
}