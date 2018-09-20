package com.florangoutang.deezertest.injection

import com.florangoutang.deezertest.ui.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent(modules = [MainActivityModule::class, FragmentBuilderModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}