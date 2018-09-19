package com.florangoutang.deezertest.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {
    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context = context
}