package com.kimi.githubuser.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.kimi.githubuser.R
import com.kimi.githubuser.data.User
import com.kimi.githubuser.model.UserViewHolder

/**
 * Created by Kimi.Peng on 2020/5/22.
 */
class UsersAdapter(
    private val clickListener : (User, ImageView) -> Unit
): PagedListAdapter<User, UserViewHolder>(
    DIFF_CALLBACK
) {


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
               return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        getItem(position)?.let {
            holder.bindData(it, clickListener)
        }


    }

}