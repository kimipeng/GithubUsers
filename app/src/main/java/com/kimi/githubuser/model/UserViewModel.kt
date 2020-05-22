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
 */
class UseViewModel : ViewModel() {


    lateinit var users: LiveData<PagedList<User>>

    init {


        val dataSource = object : DataSource.Factory<Int, User>(){
            override fun create(): DataSource<Int, User> {
               return UserItemKeyDataSource()
            }

        }
        users = LivePagedListBuilder(dataSource, 20).build()
    }

}

class UserItemKeyDataSource : ItemKeyedDataSource<Int, User>(){

    val temp = mutableListOf<User>()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<User>) {
        Log.d("kimi", "loadInitial: ")


        for (x in 0..10) {

           val user = User(
                x, "https://avatars2.githubusercontent.com/u/136?v=4",
                "simonjefford", false, "https://api.github.com/users/simonjefford"
            )

            temp.add(user)
        }

        callback.onResult(temp)

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<User>) {

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<User>) {

    }

    override fun getKey(item: User): Int {
        return item.id
    }

}