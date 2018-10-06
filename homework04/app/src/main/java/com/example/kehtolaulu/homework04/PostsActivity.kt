package com.example.kehtolaulu.homework04

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_posts.*
import kotlinx.android.synthetic.main.content_activity_posts.*

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        PostsHelper.DataProviderManager.addPosts()
        rv_books.layoutManager = LinearLayoutManager(this)
        rv_books.adapter = PostAdapter(PostsHelper.DataProviderManager.posts, this)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else ->
                // User's action was not recognized.
                super.onOptionsItemSelected(item)
        }
    }
}
