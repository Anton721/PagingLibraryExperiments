package com.example.user.paginglibrarytest

import android.arch.paging.PageKeyedDataSource
import android.arch.paging.PositionalDataSource
import android.util.Log
import com.example.user.paginglibrarytest.data.UserPost
import com.example.user.paginglibrarytest.data.db.Repository


class PostPageKeyedDataSource : PageKeyedDataSource<Int, UserPost>() {

    val TAG: String = "PageKeyed"

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UserPost>) {
        Log.i(TAG, "load after: ${params.key} ${params.requestedLoadSize}")

        if (params.requestedLoadSize < 900) {
            var result = Repository.getItemsPage(params.key, params.requestedLoadSize)
            callback.onResult(result, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UserPost>) {

    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, UserPost>) {
        Log.i(TAG, "load initial: " + params.requestedLoadSize)
        var result = Repository.getItemsPage(0, params.requestedLoadSize)
        callback.onResult(result, 0, 1)
    }


//    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<UserPost>) {
//
//        var page: Int = params.startPosition / params.loadSize
//
//        if (params.startPosition < 900) {
//            var result = Repository.getItemsPage(page, params.loadSize)
//            callback.onResult(result)
//        }
//    }
//
//    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<UserPost>) {
//        var page: Int = params.requestedStartPosition / params.pageSize
//        var result = Repository.getItemsPage(page, params.pageSize)
//        callback.onResult(result, params.requestedStartPosition)
//    }
}
