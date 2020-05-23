package com.kimi.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kimi.githubuser.model.UseViewModel
import com.kimi.githubuser.ui.UsersAdapter
import com.kimi.githubuser.ui.ItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(UseViewModel::class.java)


        val usersAdapter = UsersAdapter {
            Log.d("kimi", "onCreate: onclick ${it.login}, ${it.id} ")
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
