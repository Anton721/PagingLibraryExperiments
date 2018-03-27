package com.example.user.paginglibrarytest

import android.arch.paging.PositionalDataSource
import android.util.Log
import com.example.user.paginglibrarytest.data.UserPost


class UserPostDataSource : PositionalDataSource<UserPost>() {

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<UserPost>) {

        var page: Int = params.startPosition / params.loadSize
        Log.i("DataSource", "page: " + page + " loadSize: " + params.loadSize + " startposition: " + params.startPosition)
        if (params.startPosition < 400) {
            var result = DataSource.getItemsPage(page, params.loadSize)
            callback.onResult(result)
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<UserPost>) {
        var page: Int = params.requestedStartPosition / params.pageSize

        Log.i("DataSource initial", "page: " + page + " loadSize: " + params.pageSize + " startposition: " + params.requestedStartPosition)

        var result = DataSource.getItemsPage(page, params.pageSize)
        callback.onResult(result, params.requestedStartPosition)
    }
}
