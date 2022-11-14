package com.meteoreed.sfproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


// Все сломалось так много раз, что я уже отчаялся делать что-либо

class MainActivity : AppCompatActivity() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()

        fun launchDetailsFragment(film: Film){
            val bundle = Bundle()
            bundle.putParcelable("film",film)
            val fragment = DetailsFragment()
            fragment.arguments = bundle

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_placeholder, fragment)
                .addToBackStack(null)
                .commit()
        }




        val filmDataBase = listOf(
            Film("Coco",R.drawable.coco,"This should be a description"),
            Film("Lord of the rings 1",R.drawable.fellowship,"This should be a description"),
            Film("Lord of the rings 2",R.drawable.two_towers,"This should be a description"),
            Film("Lord of the rings 3",R.drawable.lotr,"This should be a description"),
            Film("Green mile",R.drawable.green_mile,"This should be a description"),
            Film("Forest Gump",R.drawable.gump,"This should be a description"),
            Film("Interstellar",R.drawable.interstellar,"This should be a description"),
            Film("Intouchables",R.drawable.intouchables,"This should be a description"),
            Film("Schindler's list",R.drawable.schindlers_list,"This should be a description"),
            Film("Shawshank redemption",R.drawable.shawshank,"This should be a description"),
        )

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

        main_recycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    val bundle = Bundle()
                    bundle.putParcelable("film", film)
                    val intent = Intent(this@MainActivity, DetailsFragment::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            })

            adapter = filmsAdapter

            layoutManager = LinearLayoutManager(this@MainActivity)

            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }

        filmsAdapter.addItems(filmDataBase)
    }
}