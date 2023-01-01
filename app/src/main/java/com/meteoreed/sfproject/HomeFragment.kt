package com.meteoreed.sfproject

import android.content.Intent
import android.os.Bundle
import android.transition.Scene
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.merge_home_screen_content.*
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    private val filmsDataBase = listOf(
        Film("Coco", R.drawable.coco, "This should be a description", 5.8f),
        Film("Lord of the rings 1", R.drawable.fellowship, "This should be a description", 7.4f),
        Film("Lord of the rings 2", R.drawable.two_towers, "This should be a description", 7f),
        Film("Lord of the rings 3", R.drawable.lotr, "This should be a description", 8.2f),
        Film("Green mile", R.drawable.green_mile, "This should be a description", 6.3f),
        Film("Forest Gump", R.drawable.gump, "This should be a description", 6.2f),
        Film("Interstellar", R.drawable.interstellar, "This should be a description", 5.5f),
        Film("Intouchables", R.drawable.intouchables, "This should be a description", 7.6f),
        Film("Schindler's list", R.drawable.schindlers_list, "This should be a description", 8.5f),
        Film("Shawshank redemption", R.drawable.shawshank, "This should be a description", 8.4f),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(home_fragment_root, requireActivity(), 1)

        initSearchView()

        initRecycler()
        filmsAdapter.addItems(filmsDataBase)
    }

    private fun initSearchView() {
        search_view.setOnClickListener {
            search_view.isIconified = false
        }

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                val result = filmsDataBase.filter {
                    it.title.toLowerCase(Locale.getDefault())
                        .contains(newText.toLowerCase(Locale.getDefault()))
                }
                filmsAdapter.addItems(result)
                return true
            }
        })
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


