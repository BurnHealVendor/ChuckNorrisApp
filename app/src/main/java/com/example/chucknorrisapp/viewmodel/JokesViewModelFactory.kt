package com.example.chucknorrisapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisapp.rest.JokesRepo
import javax.inject.Inject

class JokesViewModelFactory @Inject constructor(
    private val jokesRepo: JokesRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return JokesViewModel(jokesRepo) as T
    }
}