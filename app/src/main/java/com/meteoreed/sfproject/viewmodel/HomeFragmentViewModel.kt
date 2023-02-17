package com.meteoreed.sfproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.meteoreed.sfproject.App
import com.meteoreed.sfproject.domain.Film
import com.meteoreed.sfproject.domain.Interactor
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {

    val filmsListLiveData: MutableLiveData<List<Film>> = MutableLiveData()

    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
        getFilms()
    }
    fun getFilms() {

        interactor.getFilmsFromApi(1, object : ApiCallback {
            override fun onSuccess(films: List<Film>) {
                filmsListLiveData.postValue(films)
            }

            override fun onFailure() {
                filmsListLiveData.postValue(interactor.getFilmsFromDb())
            }
        })
    }


    interface ApiCallback {
        fun onSuccess(films: List<Film>)
        fun onFailure()
    }
}