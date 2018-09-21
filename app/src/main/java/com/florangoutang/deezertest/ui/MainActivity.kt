package com.florangoutang.deezertest.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import com.florangoutang.deezertest.R
import dagger.android.support.DaggerAppCompatActivity


class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
