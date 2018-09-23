package com.florangoutang.deezertest.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import com.florangoutang.deezertest.R
import dagger.android.support.DaggerAppCompatActivity


class MainActivity : DaggerAppCompatActivity(), AlbumListFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(AlbumListFragment())
    }

    override fun onFragmentInteraction(albumId: Int) {
        replaceFragment(AlbumDetailFragment.newInstance(albumId))
    }

    private fun replaceFragment(newFragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.fragmentContainer, newFragment)
        transaction.addToBackStack(null)

        transaction.commit()
    }
}
