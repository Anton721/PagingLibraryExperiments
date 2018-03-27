package com.example.user.paginglibrarytest

import com.example.user.paginglibrarytest.data.UserPost

object DataSource {
    fun getItems(startPosition: Int, endPosition: Int): List<UserPost> {
        var posts: MutableList<UserPost> = ArrayList()

        for (i in startPosition..endPosition) {
            posts.add(UserPost(i, "name: " + i, "surname: " + i))
        }
        return posts
    }

    fun getItemsPage(page:Int,pageSize:Int): List<UserPost> {
        var posts: MutableList<UserPost> = ArrayList()

        for (i in page*pageSize..(page+1)*pageSize) {
            posts.add(UserPost(i+1, "name: " + i+1, "surname: " + i+1))
        }
        return posts
    }
}