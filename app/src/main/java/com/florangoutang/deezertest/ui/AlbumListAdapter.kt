package com.florangoutang.deezertest.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.florangoutang.deezertest.R
import com.florangoutang.deezertest.ui.AlbumListAdapter.AlbumListCardViewHolder
import com.florangoutang.deezertest.interfaceadapter.model.AlbumViewModel
import com.florangoutang.deezertest.util.inflateFromParent
import com.florangoutang.deezertest.util.loadUrl
import kotlinx.android.synthetic.main.album_card.view.*

class AlbumListAdapter : RecyclerView.Adapter<AlbumListCardViewHolder>() {

    var albumList = mutableListOf<AlbumViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlbumListCardViewHolder(parent)

    override fun onBindViewHolder(holder: AlbumListCardViewHolder, position: Int) {
        holder.bind(albumList[position])
    }

    override fun getItemCount() = albumList.size

    class AlbumListCardViewHolder(itemView: ViewGroup) : RecyclerView.ViewHolder(itemView.inflateFromParent(R.layout.album_card)) {
        fun bind(albumViewModel: AlbumViewModel) = with(itemView) {
            albumImage.loadUrl(albumViewModel.coverUrl, R.drawable.album_placeholder)
        }
    }
}