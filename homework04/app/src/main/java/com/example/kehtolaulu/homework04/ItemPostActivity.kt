package com.example.kehtolaulu.homework04

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_item_post.*
import kotlinx.android.synthetic.main.activity_posts.*

class ItemPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_post)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val intent = intent
        val position = intent.getIntExtra("intVariableName", 0)
        findViewById<TextView>(R.id.post_author).text = PostsHelper.DataProviderManager.posts[position].user
        findViewById<TextView>(R.id.post_title).text = PostsHelper.DataProviderManager.posts[position].title
//        findViewById<ImageView>(R.id.post_img). = postsHelper.posts[position].img
        findViewById<TextView>(R.id.post_text).text = PostsHelper.DataProviderManager.posts[position].text
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
