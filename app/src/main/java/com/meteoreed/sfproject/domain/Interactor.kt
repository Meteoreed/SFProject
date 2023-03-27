package com.meteoreed.sfproject.domain

import androidx.lifecycle.LiveData
import com.meteoreed.sfproject.data.API
import com.meteoreed.sfproject.data.Entity.Film
import com.meteoreed.sfproject.data.Entity.TmdbResultsDto
import com.meteoreed.sfproject.data.MainRepository
import com.meteoreed.sfproject.data.PreferenceProvider
import com.meteoreed.sfproject.data.TmdbApi
import com.meteoreed.sfproject.utils.Converter
import com.meteoreed.sfproject.viewmodel.HomeFragmentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(
    private val repo: MainRepository,
    private val retrofitService: TmdbApi,
    private val preferences: PreferenceProvider
) {

    val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    val progressBarState = Channel<Boolean>(Channel.CONFLATED)

    fun getFilmsFromApi(page: Int) {
        scope.launch {
            progressBarState.send(true)
        }

        retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.KEY, "ru-RU", page)
            .enqueue(object : Callback<TmdbResultsDto> {
                override fun onResponse(
                    call: Call<TmdbResultsDto>,
                    response: Response<TmdbResultsDto>
                ) {
                    val list = Converter.convertApiListToDtoList(response.body()?.tmdbFilms)
                    scope.launch {
                        repo.putToDb(list)
                        progressBarState.send(false)
                    }
                }

                override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                    scope.launch {
                        progressBarState.send(false)
                    }
                }
            })
    }
    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }

    fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()
    fun getFilmsFromDB(): Flow<List<Film>> = repo.getAllFromDB()
}