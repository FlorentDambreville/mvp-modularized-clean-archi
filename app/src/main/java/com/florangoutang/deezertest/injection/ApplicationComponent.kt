package com.florangoutang.deezertest.injection

import android.app.Application
import com.florangoutang.deezertest.CustomApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


@Component(modules = [
    ApplicationModule::class,
    AndroidInjectionModule::class,
    ActivityBuilderModule::class,
    FragmentBuilderModule::class
])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(daggerApplication: DaggerApplication)

    fun inject(application: CustomApp)
}