package com.meteoreed.sfproject.utils

import com.meteoreed.sfproject.data.Entity.TmdbFilm
import com.meteoreed.sfproject.data.Entity.Film

object Converter {
    fun convertApiListToDtoList(list: List<TmdbFilm>?): List<Film>{
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(
                Film(
                title = it.title,
                poster = it.posterPath,
                description = it.overview,
                rating = it.voteAverage,
                isInFavorites = false
            )
            )
        }
        return result
    }
}