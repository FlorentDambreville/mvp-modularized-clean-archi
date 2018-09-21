package com.florangoutang.deezertest.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.florangoutang.deezertest.R
import com.florangoutang.deezertest.interfaceadapter.AlbumListContract
import com.florangoutang.deezertest.interfaceadapter.model.AlbumViewModel
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_album_list.*
import javax.inject.Inject

class AlbumListFragment : DaggerFragment(), AlbumListContract.View {

    @Inject lateinit var presenter: AlbumListContract.Presenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()
        setupRefreshLayout()

        presenter.attachView(this)
        presenter.getAlbumList()
    }

    override fun onDetach() {
        super.onDetach()
        presenter.unsubscribe()
    }

    override fun showAlbumListError() {
        errorTextView.visibility = View.VISIBLE
    }

    override fun showLoading(visible: Boolean) {
        errorTextView.visibility = View.GONE
        swipeToRefreshLayout.isRefreshing = visible
    }

    override fun showAlbumList(list: MutableList<AlbumViewModel>) {
        errorTextView.visibility = View.GONE
        (albumList.adapter as AlbumListAdapter).albumList = list
        albumList.adapter.notifyDataSetChanged()
    }

    private fun initAdapter() {
        if (albumList.adapter == null) {
            albumList.layoutManager = GridLayoutManager(context, 3)
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
