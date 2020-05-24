package com.kimi.githubuser.ui.main

import android.util.Log
import androidx.paging.ItemKeyedDataSource
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.failure
import com.github.kittinunf.result.success
import com.kimi.githubuser.model.User

/**
 * Created by Kimi.Peng on 2020/5/23.
 * Related Paging -> DataSource
 */
class UserItemKeyDataSource() : ItemKeyedDataSource<Int, User>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<User>) {

        // Fuel http request, Since from 0.
        "https://api.github.com/users?since=0"
            .httpGet()
            .responseObject<MutableList<User>>() { request, response, result ->
                result.success {
                    Log.d("kimi", "[loadInitial] Loading completed, Response Data Size:${it.size} ")
                    callback.onResult(it)
                }

                result.failure {
                    Log.d("kimi", "[loadInitial] Error: ${it.response}")
                }
            }


    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<User>) {

        // Fuel http request, Since by key value.
        "https://api.github.com/users?since=${params.key}"
            .httpGet()
            .responseObject<MutableList<User>>() { request, response, result ->
                result.success {
                    Log.d("kimi", "[loadAfter] Loading completed, Since From ${params.key}, Response Data Size:${it.size} ")
                    callback.onResult(it)
                }

                result.failure {
                    Log.d("kimi", "[loadAfter] Error: ${it.response}")
                }
            }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<User>) {
        // In this case don't  implement this function.
    }

    override fun getKey(item: User): Int {
        return item.id
    }

}