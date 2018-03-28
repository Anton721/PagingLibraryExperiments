package com.example.user.paginglibrarytest

import android.arch.paging.DataSource
import com.example.user.paginglibrarytest.data.UserPost

class UserPostDataSourceFactory : DataSource.Factory<Int, UserPost>() {
    override fun create(): DataSource<Int, UserPost> = PostPageKeyedDataSource()
}