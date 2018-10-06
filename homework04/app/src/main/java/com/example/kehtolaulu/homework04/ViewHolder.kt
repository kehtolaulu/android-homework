package com.example.kehtolaulu.homework04

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_post.view.*

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle = view.tv_title!!
    val tvUser = view.tv_user!!
    val btnMore = view.btn_more!!
}