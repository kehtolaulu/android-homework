package com.example.kehtolaulu.homework04

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup


class PostAdapter(private val items: ArrayList<Post>, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of posts in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_post, parent, false))
    }

    // Binds each post in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = items[position].title
        holder.tvUser.text = items[position].user
        holder.btnMore.setOnClickListener {
            val intent = Intent(context, ItemPostActivity::class.java)
            intent.putExtra("intVariableName", position)
            context.startActivity(intent)
        }
    }


}

