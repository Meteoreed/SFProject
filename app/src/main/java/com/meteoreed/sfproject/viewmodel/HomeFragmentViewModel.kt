package com.meteoreed.sfproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meteoreed.sfproject.App
import com.meteoreed.sfproject.domain.Film
import com.meteoreed.sfproject.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val filmsListLiveData: MutableLiveData<List<Film>> = MutableLiveData()
    private var interactor: Interactor = App.instance.interactor

    init {
        val films = interactor.getFilmsDB()
        filmsListLiveData.postValue(films)
    }
}