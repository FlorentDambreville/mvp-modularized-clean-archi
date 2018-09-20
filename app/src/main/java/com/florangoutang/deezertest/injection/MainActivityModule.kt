package com.florangoutang.deezertest.injection

import com.florangoutang.deezertest.ui.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainActivity() : MainActivity {
        return MainActivity()
    }
}