package com.example.chucknorrisapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorrisapp.rest.JokesRepo
import com.example.chucknorrisapp.utils.JokesState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class JokesViewModel @Inject constructor(
    private val jokesRepo: JokesRepo,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _jokes: MutableLiveData<JokesState> = MutableLiveData(JokesState.LOADING)

    val jokes: LiveData<JokesState> get() = _jokes

    fun getRandomJoke(id: Int) {
        viewModelScope.launch(ioDispatcher) {
            try {
                val response = jokesRepo.getRandom(id)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _jokes.postValue(JokesState.SUCCESS(it))
                    } ?: throw Exception("Response is null")
                }
                else {
                    throw Exception("No successful response")
                }
            }
            catch (e: Exception) {
                _jokes.postValue(JokesState.ERROR(e))
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("JokesViewModel", "ViewModel destroyed")
    }
}