package com.florangoutang.deezertest.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.florangoutang.deezertest.R
import com.florangoutang.deezertest.interfaceadapter.album.detail.AlbumDetailContract
import com.florangoutang.deezertest.interfaceadapter.album.detail.model.AlbumDetailViewModel
import com.florangoutang.deezertest.util.loadUrl
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_album_detail.*
import javax.inject.Inject

class AlbumDetailFragment : DaggerFragment(), AlbumDetailContract.View {

    @Inject lateinit var presenter : AlbumDetailContract.Presenter
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()

        presenter.attachView(this)
        albumId?.let {  presenter.getAlbumDetail(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
        presenter.detachView()
    }

    override fun albumDetailError(message: String?) {

    }

    override fun showLoading(visible: Boolean) {

    }

    override fun showAlbumDetail(albumDetailViewModel: AlbumDetailViewModel) {
        (songList.adapter as SongListAdapter).songList = albumDetailViewModel.songList.toMutableList()
        albumDetailCover.loadUrl(albumDetailViewModel.coverUrl, R.drawable.album_placeholder)
    }

    private fun initAdapter() {
        if (songList.adapter == null) {
            songList.layoutManager = LinearLayoutManager(context)
            songList.adapter = SongListAdapter()
        }
    }

}
