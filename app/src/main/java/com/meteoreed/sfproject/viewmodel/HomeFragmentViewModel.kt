package com.meteoreed.sfproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meteoreed.sfproject.App
import com.meteoreed.sfproject.data.Entity.Film
import com.meteoreed.sfproject.domain.Interactor
import java.nio.channels.Channel
import java.util.concurrent.Flow
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {

    @Inject
    lateinit var interactor: Interactor
    val filmsListData: Flow<List<Film>>
    val showProgressBar: Channel<Boolean>

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarState
        filmsListData = interactor.getFilmsFromDB()
        getFilms()
    }

    fun getFilms() {
        interactor.getFilmsFromApi(1)
    }
}