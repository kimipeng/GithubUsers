package com.kimi.githubuser.model

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kimi.githubuser.R
import com.kimi.githubuser.data.User
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by Kimi.Peng on 2020/5/22.
 */
class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    val ivAvatar = itemView.iv_avatar
    val tvLogin = itemView.tv_login
    val tvBadge = itemView.tv_badge


    fun bindData(
        user: User,
        clickListener: (User) -> Unit
    ) {

        itemView.setOnClickListener {  clickListener(user) }
        tvBadge.visibility = if (user.siteAdmin) View.VISIBLE else View.GONE
        tvLogin.text = user.login + " ${user.id}"

        // Loading image from avatar url.
        Glide
            .with(itemView.context)
            .load(user.avatarUrl)
            .centerCrop()
            .placeholder(R.drawable.github_mark)
            .into(ivAvatar)


    }
}