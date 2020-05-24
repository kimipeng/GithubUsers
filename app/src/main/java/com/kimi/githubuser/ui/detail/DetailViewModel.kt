package com.kimi.githubuser.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.failure
import com.github.kittinunf.result.success
import com.kimi.githubuser.model.User
import com.kimi.githubuser.model.UserDetail
import kotlinx.coroutines.launch

/**
 * Created by Kimi.Peng on 2020/5/23.
 */
class DetailViewModel : ViewModel() {


    private val _name = MutableLiveData<String>()

    val name: LiveData<String>
        get() = _name

    private val _bio = MutableLiveData<String>()

    val bio: LiveData<String>
        get() = _bio

    private val _login = MutableLiveData<String>()

    val login: LiveData<String>
        get() = _login

    private val _siteAdmin = MutableLiveData<Boolean>()

    val siteAdmin: LiveData<Boolean>
        get() = _siteAdmin


    private val _location = MutableLiveData<String>()

    val location: LiveData<String>
        get() = _location

    private val _blog = MutableLiveData<String>()

    val blog: LiveData<String>
        get() = _blog


    init {
        initWordData()
    }

    private fun initWordData() {
        _name.value = "Name loading..."
        _bio.value = "Bio loading..."
        _login.value = "Login loading..."
        _siteAdmin.value = false
        _location.value = "Location loading.."
        _blog.value = "Blog loading.."
    }


    fun loadUserData(user: User) {

        viewModelScope.launch {
            user.url
                .httpGet()
                .responseObject<UserDetail>() { request, response, result ->
                    result.success {
                        //callBack(it)
                        updateData(it)
                    }

                    result.failure {
                        Log.d("kimi", "failure: ${it.response}")
                    }
                }
        }
    }

    private fun updateData(it: UserDetail) {
        _name.postValue(it.name)
        _bio.postValue(it.bio)
        _login.postValue(it.login)
        _siteAdmin.postValue(it.site_admin)
        _location.postValue(it.location)
        _blog.postValue(it.blog)
    }


}