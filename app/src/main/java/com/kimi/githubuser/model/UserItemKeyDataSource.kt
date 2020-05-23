package com.kimi.githubuser.model

import android.util.Log
import androidx.paging.ItemKeyedDataSource
import com.kimi.githubuser.data.User

/**
 * Created by Kimi.Peng on 2020/5/23.
 * Related Paging -> DataSource
 */
class UserItemKeyDataSource(): ItemKeyedDataSource<Int, User>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<User>) {
        Log.d("kimi", "loadInitial: ")

        val temp = mutableListOf<User>()
        for (x in 1..5) {

            val user = User(
                x, "https://avatars2.githubusercontent.com/u/136?v=4",
                "simonjefford", false, "https://api.github.com/users/simonjefford"
            )

            temp.add(user)
        }

        callback.onResult(temp)

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<User>) {
        Log.d("kimi", "loadAfter: ${params.key}")

        val temp = mutableListOf<User>()
        for (x in 1..5) {

            val user = User(
                x + params.key, "https://avatars2.githubusercontent.com/u/136?v=4",
                "simonjefford", false, "https://api.github.com/users/simonjefford"
            )

            temp.add(user)
        }

        callback.onResult(temp)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<User>) {
        // In this case don't  implement this function.
    }

    override fun getKey(item: User): Int {
        return item.id
    }

}