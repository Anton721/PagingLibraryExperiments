package com.example.user.paginglibrarytest

import android.arch.lifecycle.Observer
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(30)
                .build()

        var pagedListLiveData = LivePagedListBuilder(UserPostDataSourceFactory(),config)
                .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor()).build()

        var adapter = UserPostAdapter(DiffUtilCallback())

        pagedListLiveData.observe(this, Observer{it?.let {adapter.submitList(it)} })

        var rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setAdapter(adapter);
    }
}
