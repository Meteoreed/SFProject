package com.meteoreed.sfproject.domain

import com.meteoreed.sfproject.data.API
import com.meteoreed.sfproject.data.Entity.TmdbResultsDto
import com.meteoreed.sfproject.data.MainRepository
import com.meteoreed.sfproject.data.TmdbApi
import com.meteoreed.sfproject.utils.Converter
import com.meteoreed.sfproject.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi) {
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getFilms(API.KEY, "ru-RU", page).enqueue(object : Callback<TmdbResultsDto> {
            override fun onResponse(
                call: Call<TmdbResultsDto>,
                response: Response<TmdbResultsDto>
            ) {
                callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.tmdbFilms))
            }

            override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}