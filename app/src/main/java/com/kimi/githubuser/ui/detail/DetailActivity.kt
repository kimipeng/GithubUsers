package com.kimi.githubuser.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kimi.githubuser.R
import com.kimi.githubuser.model.User
import com.kimi.githubuser.databinding.ActivityDetailBinding
import com.kimi.githubuser.model.UserDetail
import com.kimi.githubuser.util.loadingURL

import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    var user: User? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.setLifecycleOwner(this)
        setContentView(binding.root)

        // Change Top-left icon
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.baseline_close_24)
        }

        // viewModel init
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        // Set binding viewModel
        binding.viewModel = viewModel

        
        user = intent.getParcelableExtra(EXTRA_USER_DETAIL)
        user?.let {
            iv_avatar.loadingURL(it.avatarUrl)
            viewModel.loadUserData(it)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    companion object {

        @JvmStatic
        val EXTRA_USER_DETAIL = "EXTRA_USER_DETAIL"
    }

}
