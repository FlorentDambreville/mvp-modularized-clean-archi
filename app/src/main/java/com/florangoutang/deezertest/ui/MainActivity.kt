package com.florangoutang.deezertest.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import com.florangoutang.deezertest.R
import dagger.android.support.DaggerAppCompatActivity


class MainActivity : DaggerAppCompatActivity(), AlbumListFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AlbumListFragment())
                .commit()
    }

    override fun onFragmentInteraction(albumId: Int) {
        val newFragment = AlbumDetailFragment.newInstance(albumId)
        supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, newFragment)
                .addToBackStack(newFragment.tag)
                .commit()
    }

}
