package com.florangoutang.deezertest.injection

import android.content.Context
import com.florangoutang.deezertest.CustomApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    AlbumListModule::class
])
interface AppComponent {
    object Initializer {

        private lateinit var component: AppComponent

        @Synchronized
        fun getApplicationComponent(context: Context): AppComponent {
            if (!::component.isInitialized) {
                initInjection(context)
            }
            return component
        }

        private fun initInjection(context: Context) {
            component = DaggerAppComponent.builder()
                    .applicationModule(ApplicationModule(context.applicationContext))
                    .build()
        }
    }

    fun inject(application: CustomApp)
}