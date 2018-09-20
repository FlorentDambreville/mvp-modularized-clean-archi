package com.florangoutang.deezertest.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.florangoutang.deezertest.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject



class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(AlbumListFragment())
    }

    private fun replaceFragment(newFragment : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.fragmentContrainer, newFragment)
        transaction.addToBackStack(null)

        transaction.commit()
    }
}
