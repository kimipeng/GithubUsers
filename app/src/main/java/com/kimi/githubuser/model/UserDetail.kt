package com.kimi.githubuser.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Kimi.Peng on 2020/5/23.
 */
data class UserDetail(
    @SerializedName("avatar_url") val avatar_url: String,
    @SerializedName("name") val name: String,
    @SerializedName("bio") val bio: String,
    @SerializedName("login") val login: String,
    @SerializedName("site_admin") val site_admin: Boolean,
    @SerializedName("blog") val blog: String,
    @SerializedName("location") val location: String
)