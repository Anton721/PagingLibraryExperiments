package com.example.user.paginglibrarytest

import android.arch.paging.DataSource
import com.example.user.paginglibrarytest.data.UserPost

class PostDataSourceFactory(var dataSource: DataSource<Int,UserPost>) : DataSource.Factory<Int, UserPost>() {
    override fun create(): DataSource<Int, UserPost> = dataSource
}