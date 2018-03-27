package com.example.user.paginglibrarytest

import android.arch.paging.PagedListAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.user.paginglibrarytest.data.UserPost
import kotlinx.android.synthetic.main.item_recyclerview.view.*
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater




class UserPostAdapter : PagedListAdapter<UserPost, UserPostAdapter.UserPostViewHolder> {

    constructor(diffUtilCallback: DiffUtil.ItemCallback<UserPost>) : super(diffUtilCallback);

    override fun onBindViewHolder(holder: UserPostViewHolder, position: Int) {
        holder.bindData(getItem(position)!!);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return UserPostViewHolder(view)
    }

    class UserPostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val id: TextView = itemView.text_id
        val name: TextView = itemView.text_name
        val surname: TextView = itemView.text_surname

        fun bindData(post: UserPost) {
                id.text = post.id.toString()
                name.text = post.name
                surname.text = post.surname
        }
    }

}
