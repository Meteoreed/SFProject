package com.meteoreed.sfproject.domain

import com.meteoreed.sfproject.data.API
import com.meteoreed.sfproject.data.Entity.TmdbResultsDto
import com.meteoreed.sfproject.data.MainRepository
import com.meteoreed.sfproject.data.PreferenceProvider
import com.meteoreed.sfproject.data.TmdbApi
import com.meteoreed.sfproject.utils.Converter
import com.meteoreed.sfproject.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.prefs.Preferences

class Interactor(
    private val repo: MainRepository,
    private val retrofitService: TmdbApi,
    private val preferences: PreferenceProvider
) {
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getFilms(getDefaultCategoryFromPreferences()!!, API.KEY, "ru-RU", page)
            .enqueue(object : Callback<TmdbResultsDto> {
                override fun onResponse(
                    call: Call<TmdbResultsDto>,
                    response: Response<TmdbResultsDto>
                ) {
                    val list = Converter.convertApiListToDtoList(response.body()?.tmdbFilms)
                    list.forEach {
                        repo.putToDb(film = it)
                    }
                    callback.onSuccess(list)
                }

                override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                    callback.onFailure()
                }
            })
    }

    fun getFilmsFromDb(): List<Film> = repo.getAllFromDb()

    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }

    fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()
}