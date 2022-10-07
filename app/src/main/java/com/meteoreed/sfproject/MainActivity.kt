package com.meteoreed.sfproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_menu.setOnClickListener {
            Toast.makeText(this, "меню", Toast.LENGTH_SHORT).show()
        }
        btn_collections.setOnClickListener {
            Toast.makeText(this, "подборки", Toast.LENGTH_SHORT).show()
        }
        btn_favorite.setOnClickListener {
            Toast.makeText(this, "избранное", Toast.LENGTH_SHORT).show()
        }
        btn_settings.setOnClickListener {
            Toast.makeText(this, "настройки", Toast.LENGTH_SHORT).show()
        }
        btn_watch_later.setOnClickListener {
            Toast.makeText(this, "посмотреть позже", Toast.LENGTH_SHORT).show()
        }
    }
}