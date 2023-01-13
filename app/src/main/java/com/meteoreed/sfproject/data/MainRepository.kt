package com.meteoreed.sfproject.data

import com.meteoreed.sfproject.R
import com.meteoreed.sfproject.domain.Film

class MainRepository {
    val filmsDataBase = listOf(
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
}