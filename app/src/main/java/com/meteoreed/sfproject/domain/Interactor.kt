package com.meteoreed.sfproject.domain

import com.meteoreed.sfproject.data.MainRepository

class Interactor(val repo: MainRepository) {
fun getFilmsDB(): List<Film> = repo.filmsDataBase
}