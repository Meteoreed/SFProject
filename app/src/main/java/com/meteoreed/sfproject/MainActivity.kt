package com.meteoreed.sfproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.btn_settings -> {
                    Toast.makeText(this, R.string.btn_settings, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }


        bottom_navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.btn_favorite -> {
                    Toast.makeText(this, R.string.btn_favorite, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.btn_watch_later -> {
                    Toast.makeText(this, R.string.btn_watch_later, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.btn_collections -> {
                    Toast.makeText(this, R.string.btn_collections, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}