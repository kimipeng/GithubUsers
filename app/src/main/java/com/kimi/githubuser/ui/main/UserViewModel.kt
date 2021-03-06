package com.kimi.githubuser.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.kimi.githubuser.model.User

/**
 * Created by Kimi.Peng on 2020/5/22.
 */
class UseViewModel : ViewModel() {


    lateinit var users: LiveData<PagedList<User>>

    init {
        initPagedList()
    }

    private fun initPagedList() {

        // init DataSource
        val dataSource = object : DataSource.Factory<Int, User>() {
            override fun create(): DataSource<Int, User> {
                return UserItemKeyDataSource()
            }

        }

        // set paging size
        val pagedListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setPrefetchDistance(4)
            .setEnablePlaceholders(true)
            .setMaxSize(100)
            .build()

        users = LivePagedListBuilder(dataSource, pagedListConfig).build()
    }

}

