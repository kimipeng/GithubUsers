package com.kimi.githubuser.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.ItemKeyedDataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.kimi.githubuser.data.User

/**
 * Created by Kimi.Peng on 2020/5/22.
https://api.github.com/users?since=0
 */
class UseViewModel : ViewModel() {


    lateinit var users: LiveData<PagedList<User>>

    init {
        initPagedList()
    }

    private fun initPagedList() {
        val dataSource = object : DataSource.Factory<Int, User>() {
            override fun create(): DataSource<Int, User> {
                return UserItemKeyDataSource()
            }

        }

        val pagedListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setPrefetchDistance(4)
            .setEnablePlaceholders(true)
            .setMaxSize(20)
            .build()

        //users = LivePagedListBuilder(dataSource, 20).build()
        users = LivePagedListBuilder(dataSource, pagedListConfig).build()
    }

}

