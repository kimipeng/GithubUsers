package com.kimi.githubuser.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.kimi.githubuser.R

/**
 * Created by Kimi.Peng on 2020/5/23.
 */
fun ImageView.loadingURL(url: String) {
    Glide
        .with(this.context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.github_mark)
        .into(this)
}