package com.meteoreed.sfproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    private val filmDataBase = listOf(
        Film("Coco", R.drawable.coco, "This should be a description"),
        Film("Lord of the rings 1", R.drawable.fellowship, "This should be a description"),
        Film("Lord of the rings 2", R.drawable.two_towers, "This should be a description"),
        Film("Lord of the rings 3", R.drawable.lotr, "This should be a description"),
        Film("Green mile", R.drawable.green_mile, "This should be a description"),
        Film("Forest Gump", R.drawable.gump, "This should be a description"),
        Film("Interstellar", R.drawable.interstellar, "This should be a description"),
        Film("Intouchables", R.drawable.intouchables, "This should be a description"),
        Film("Schindler's list", R.drawable.schindlers_list, "This should be a description"),
        Film("Shawshank redemption", R.drawable.shawshank, "This should be a description"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search_view.setOnClickListener {
            search_view.isIconified = false
        }

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmDataBase)
                    return true
                }
                val result = filmDataBase.filter {
                    it.title.toLowerCase(Locale.getDefault())
                        .contains(newText.toLowerCase(Locale.getDefault()))
                }
                filmsAdapter.addItems(result)
                return true
            }
        })

        initRecycler()
        filmsAdapter.addItems(filmDataBase)
    }

    private fun initRecycler() {
        main_recycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
    }
}


