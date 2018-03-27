package com.example.user.paginglibrarytest

import android.support.v7.util.DiffUtil
import com.example.user.paginglibrarytest.data.UserPost

class ProductDiffUtilCallback : DiffUtil.ItemCallback<UserPost>() {

    override fun areItemsTheSame(oldItem: UserPost?, newItem: UserPost?): Boolean {
        return oldItem?.id == newItem?.id
    }

    override fun areContentsTheSame(oldItem: UserPost?, newItem: UserPost?): Boolean {
        return oldItem?.name.equals(newItem?.name) &&
                oldItem?.surname.equals(newItem?.surname)    }
}
