package com.florangoutang.deezertest.injection

import android.app.Application
import com.florangoutang.deezertest.CustomApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule


@Component(modules = [
    ApplicationModule::class,
    AndroidInjectionModule::class,
    ActivityBuilderModule::class
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: CustomApp)
}