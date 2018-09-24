package com.florangoutang.deezertest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.florangoutang.deezertest.R
import com.florangoutang.deezertest.interfaceadapter.album.detail.AlbumDetailContract
import com.florangoutang.deezertest.interfaceadapter.album.detail.model.AlbumDetailViewModel
import dagger.android.support.DaggerFragment
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

        presenter.attachView(this)
        albumId?.let {  presenter.getAlbumDetail(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
        presenter.detachView()
    }

    override fun albumDetailError(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading(visible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAlbumDetail(list: AlbumDetailViewModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
