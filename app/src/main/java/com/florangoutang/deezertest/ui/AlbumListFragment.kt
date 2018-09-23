package com.florangoutang.deezertest.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.florangoutang.deezertest.R
import com.florangoutang.deezertest.interfaceadapter.album.list.AlbumListContract
import com.florangoutang.deezertest.interfaceadapter.album.list.model.AlbumListViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_album_list.*
import javax.inject.Inject

class AlbumListFragment : DaggerFragment(), AlbumListContract.View {

    @Inject lateinit var presenter: AlbumListContract.Presenter
    private var listener: OnFragmentInteractionListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_album_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity is OnFragmentInteractionListener) {
            listener = activity as OnFragmentInteractionListener
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()
        setupRefreshLayout()

        presenter.attachView(this)
        presenter.getAlbumList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
        listener = null
    }

    override fun showAlbumListError(message: String?) {
        setComponentToDisplay(AlbumListComponentVisibility.ERROR_MESSAGE)
        errorTextView.append("\n")
        errorTextView.append(message)
    }

    override fun showLoading(visible: Boolean) {
        swipeToRefreshLayout.isRefreshing = visible
    }

    override fun showAlbumList(list: MutableList<AlbumListViewModel>) {
        setComponentToDisplay(AlbumListComponentVisibility.LIST)
        (albumList.adapter as AlbumListAdapter).albumList = list
        albumList.adapter.notifyDataSetChanged()
    }

    override fun addToAlbumList(list: MutableList<AlbumListViewModel>) {
        setComponentToDisplay(AlbumListComponentVisibility.LIST)
        (albumList.adapter as AlbumListAdapter).albumList.addAll(list)
        albumList.adapter.notifyDataSetChanged()
    }


    private fun setComponentToDisplay(componentToDisplay: AlbumListComponentVisibility) {
        when (componentToDisplay) {
            AlbumListComponentVisibility.LIST -> {
                errorTextView.visibility = View.GONE
                albumList.visibility = View.VISIBLE
            }
            AlbumListComponentVisibility.ERROR_MESSAGE -> {
                errorTextView.visibility = View.VISIBLE
                albumList.visibility = View.GONE
            }
        }
    }

    private fun initAdapter() {
        if (albumList.adapter == null) {
            albumList.layoutManager = GridLayoutManager(context, 3)
            albumList.adapter = AlbumListAdapter(object : OnAlbumClickedListener {
                override fun onAlbumClicked(albumId: Int) {
                    listener?.onFragmentInteraction(albumId)
                }
            })
            { positionInList: Int, itemCount: Int ->
                presenter.getNextAlbumListIfNecessary(positionInList, itemCount)
            }
        }
    }

    private fun setupRefreshLayout() {
        swipeToRefreshLayout.setColorSchemeResources(R.color.colorPrimary)
        swipeToRefreshLayout.setOnRefreshListener {
            presenter.getAlbumList(reInitList = true)
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(albumId: Int)
    }

    interface OnAlbumClickedListener {
        fun onAlbumClicked(albumId: Int)
    }
}

enum class AlbumListComponentVisibility {
    LIST,
    ERROR_MESSAGE
}
