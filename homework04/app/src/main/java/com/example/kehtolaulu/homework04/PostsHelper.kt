package com.example.kehtolaulu.homework04

class PostsHelper internal constructor() {

    object DataProviderManager {
        val posts: ArrayList<Post> = ArrayList()
        fun addPosts() {
            if (posts.isEmpty()) {
                posts.add(Post("My first post", "user1", R.drawable.ic_launcher_background, "text"))
                posts.add(Post("Second post", "user2", R.drawable.ic_launcher_background, "text"))
            }
        }
    }
}
