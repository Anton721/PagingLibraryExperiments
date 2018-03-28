package com.example.user.paginglibrarytest

import android.arch.paging.PositionalDataSource
import android.util.Log
import com.example.user.paginglibrarytest.data.UserPost
import com.example.user.paginglibrarytest.data.db.Repository


class PostPositionalDataSource : PositionalDataSource<UserPost>() {
    val TAG: String = "Positional"

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<UserPost>) {
        Log.i(TAG, "load after: ${params.startPosition} ${params.loadSize}")
        var startPosition: Int = params.startPosition
        var endPosition: Int = startPosition + params.loadSize
        var resoult = Repository.getItemsPosition(startPosition, endPosition)
        callback.onResult(resoult)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<UserPost>) {
        Log.i(TAG, "load after: ${params.requestedStartPosition} ${params.requestedLoadSize}")
        var startPosition: Int = params.requestedStartPosition
        var endPosition: Int = startPosition + params.requestedLoadSize
        var result = Repository.getItemsPosition(startPosition,endPosition)
        callback.onResult(result, params.requestedStartPosition)
    }
}
