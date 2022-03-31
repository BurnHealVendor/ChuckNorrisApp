package com.example.chucknorrisapp.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisapp.rest.JokesRepo
import com.example.chucknorrisapp.viewmodel.JokesViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(
    private val applicationContext: Context
) {

    @Provides
    fun providesContext(): Context {
        return applicationContext
    }

    @Provides
    @Singleton
    fun providesJokesViewModelFactory(jokesRepo: JokesRepo): ViewModelProvider.Factory =
        JokesViewModelFactory(jokesRepo)
}