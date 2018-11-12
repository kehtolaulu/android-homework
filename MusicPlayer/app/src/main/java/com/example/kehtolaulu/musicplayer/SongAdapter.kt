package com.example.kehtolaulu.musicplayer

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kehtolaulu.musicplayer.SongAdapter.SongHolder

class SongAdapter(diffCallback: DiffUtil.ItemCallback<Song>, private val callback: Callback) : ListAdapter<Song, SongHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song, parent, false)
        return SongHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SongHolder, position: Int) {
        viewHolder.id = position
        viewHolder.itemView.setOnClickListener { callback.callback(viewHolder.id) }
        viewHolder.tvName.text = getItem(position).name
    }

    inner class SongHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var id: Int = 0
        var tvName: TextView
        init {
            tvName = view.findViewById(R.id.tv_name)
        }
    }
}