package com.kimi.githubuser.ui.main

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kimi.githubuser.model.User
import com.kimi.githubuser.util.loadingURL
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
        clickListener: (User, ImageView) -> Unit
    ) {

        // when user click it will invoke callback, then it will intent to DetailActivity.
        itemView.setOnClickListener {  clickListener(user, ivAvatar) }

        tvBadge.visibility = if (user.siteAdmin) View.VISIBLE else View.GONE
        tvLogin.text = user.login + " ${user.id}"

        // Loading image from avatar url.
        ivAvatar.loadingURL(user.avatarUrl)

    }
}