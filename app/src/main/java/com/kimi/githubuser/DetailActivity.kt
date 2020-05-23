package com.kimi.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.github.kittinunf.fuel.httpGet
import com.kimi.githubuser.data.User

import com.kimi.githubuser.ui.loadingURL
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    var user: User? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.baseline_close_24)
        }

        user = intent.getParcelableExtra(EXTRA_USER_DETAIL)

        user?.let {
            Log.d("kimi", "onCreate: ${it.login}")

            iv_avatar.loadingURL(it.avatarUrl)
            //it.url.httpGet().


        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->{
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
