package com.example.user.paginglibrarytest

import android.arch.paging.PositionalDataSource
import com.example.user.paginglibrarytest.data.UserPost
import com.example.user.paginglibrarytest.data.db.Repository


class PostPositionalDataSource : PositionalDataSource<UserPost>() {


    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<UserPost>) {

        var page: Int = params.startPosition / params.loadSize

        if (params.startPosition < 900) {
            var result = Repository.getItemsPage(page, params.loadSize)
            callback.onResult(result)
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<UserPost>) {
        var page: Int = params.requestedStartPosition / params.pageSize
        var result = Repository.getItemsPage(page, params.pageSize)
        callback.onResult(result, params.requestedStartPosition)
    }
}
