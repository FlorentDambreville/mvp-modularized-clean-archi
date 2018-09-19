package com.florangoutang.deezertest

import android.app.Application
import com.florangoutang.deezertest.injection.AppComponent

class CustomApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppComponent.Initializer.getApplicationComponent(this).inject(this)
    }
}