package com.example.chucknorrisapp.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisapp.rest.JokesRepo
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(
    private val applicationContext: Context
) {

    @Provides
    fun providesContext(): Context {
        return applicationContext
    }
}