package com.florangoutang.deezertest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.florangoutang.deezertest.interfaceadapter.AlbumListContract
import kotlinx.android.synthetic.main.fragment_album_list.*
import javax.inject.Inject

class AlbumListFragment : Fragment() {

    @Inject
    lateinit var presenter: AlbumListContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()
        setupRefreshLayout()

        presenter.getAlbumList()
    }

    override fun onDetach() {
        super.onDetach()
        presenter.unsubscribe()
    }

    private fun initAdapter() {
        if (albumList.adapter == null) {
            albumList.layoutManager = LinearLayoutManager(context)
            albumList.adapter = AlbumListAdapter()
        }
    }

    private fun setupRefreshLayout() {
        swipeToRefreshLayout.setColorSchemeResources(R.color.colorPrimary)
        swipeToRefreshLayout.setOnRefreshListener {
            presenter.getAlbumList()
        }
    }
}
