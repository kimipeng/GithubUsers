package com.kimi.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kimi.githubuser.DetailActivity.Companion.EXTRA_USER_DETAIL
import com.kimi.githubuser.data.User
import com.kimi.githubuser.model.UseViewModel
import com.kimi.githubuser.ui.UsersAdapter
import com.kimi.githubuser.ui.ItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(UseViewModel::class.java)


        val usersAdapter = UsersAdapter { user,  transitionView->
            Log.d("kimi", "onCreate: onclick ${user.login}, ${user.id} ")

            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(EXTRA_USER_DETAIL, user)
            val option = ActivityOptionsCompat.makeSceneTransitionAnimation(this, transitionView, ViewCompat.getTransitionName(transitionView)!!)
            startActivity(intent, option.toBundle())
        }

        val pixelSize = resources.getDimensionPixelSize(R.dimen.item_decoration_margin)
        recycler.addItemDecoration(ItemDecoration(pixelSize))
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = usersAdapter

        viewModel.users.observe(this, Observer {
            usersAdapter.submitList(it)
        })

    }
}
