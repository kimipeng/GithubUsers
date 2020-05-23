package com.kimi.githubuser.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Kimi.Peng on 2020/5/22.
 * https://api.github.com/users?since=135
 */
@Parcelize
data class User(
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("login")val login: String,
    @SerializedName("site_admin") val siteAdmin: Boolean,
    @SerializedName("url") val url: String
): Parcelable