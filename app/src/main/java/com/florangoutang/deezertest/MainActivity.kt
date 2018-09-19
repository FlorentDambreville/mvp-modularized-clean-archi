package com.florangoutang.deezertest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

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
