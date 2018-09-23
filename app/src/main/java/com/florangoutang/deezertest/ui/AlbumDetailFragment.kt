package com.florangoutang.deezertest.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.florangoutang.deezertest.R

class AlbumDetailFragment : Fragment() {

    private var albumId : Int? = null

    companion object {
        private const val ARG_ALBUM_ID = "param1"

        @JvmStatic
        fun newInstance(albumId: Int) =
                AlbumDetailFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_ALBUM_ID, albumId)
                    }
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            albumId = it.getInt(ARG_ALBUM_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_detail, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }
}
