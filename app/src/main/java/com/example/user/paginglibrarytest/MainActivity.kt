package com.example.user.paginglibrarytest

import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.annotation.MainThread
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.user.paginglibrarytest.data.UserPost
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(40)
                .build()

        val dataSource = UserPostDataSource()

        val diskExecutor = Executors.newFixedThreadPool(2)
        val mainHandler = Handler(Looper.getMainLooper())

        var pagedList: PagedList<UserPost> = PagedList.Builder<Int, UserPost>(dataSource, config)
                .setMainThreadExecutor({ mainHandler.post(it) })
                .setBackgroundThreadExecutor(diskExecutor)
                //.setInitialKey(120)
                .build();
        var adapter = UserPostAdapter(ProductDiffUtilCallback());
        adapter.submitList(pagedList);

        var rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setAdapter(adapter);
    }
}
