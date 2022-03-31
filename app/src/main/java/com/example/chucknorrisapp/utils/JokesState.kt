package com.example.chucknorrisapp.utils

sealed class JokesState {
    object LOADING : JokesState()
    class SUCCESS<T>(val jokes: T) : JokesState()
    class ERROR(val error: Throwable) : JokesState()
}