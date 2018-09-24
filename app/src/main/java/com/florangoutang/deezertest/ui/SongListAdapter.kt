package com.florangoutang.deezertest.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.florangoutang.deezertest.R
import com.florangoutang.deezertest.ui.SongListAdapter.SongListViewHolder
import com.florangoutang.deezertest.util.inflateFromParent
import kotlinx.android.synthetic.main.song_item.view.*

class SongListAdapter : RecyclerView.Adapter<SongListViewHolder>() {

    var songList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SongListViewHolder(parent)

    override fun onBindViewHolder(holder: SongListViewHolder, position: Int) {
        holder.bind(songList[position])
    }

    override fun getItemCount() = songList.size

    class SongListViewHolder(itemView: ViewGroup) : RecyclerView.ViewHolder(itemView.inflateFromParent(R.layout.song_item)) {
        fun bind(song: String) = with(itemView) {
            songTitle.text = song
        }
    }
}