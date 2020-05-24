package com.kimi.githubuser.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kimi.githubuser.R
import com.kimi.githubuser.ui.detail.DetailActivity.Companion.EXTRA_USER_DETAIL
import com.kimi.githubuser.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init viewModel
        val viewModel = ViewModelProvider(this).get(UseViewModel::class.java)

        // Init adapter, it extends PagedListAdapter. And implement callback when user click item.
        val usersAdapter =
            UsersAdapter { user, transitionView ->
                val intent = Intent(this@MainActivity, DetailActivity::class.java)

                // Intent putExtra object.
                intent.putExtra(EXTRA_USER_DETAIL, user)

                // Make TransitionAnimation when intent to other activity.
                val option = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    transitionView,
                    ViewCompat.getTransitionName(transitionView)!!
                )

                startActivity(intent, option.toBundle()) // Execute to anther activity.
            }

        // Set item of padding in Recyclerview
        val pixelSize = resources.getDimensionPixelSize(R.dimen.item_decoration_margin)
        recycler.addItemDecoration(
            ItemDecoration(
                pixelSize
            )
        )

        // Set layout manager to VERTICAL
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = usersAdapter


        // Register view model observer
        viewModel.users.observe(this, Observer {
            usersAdapter.submitList(it)
        })

    }
}
