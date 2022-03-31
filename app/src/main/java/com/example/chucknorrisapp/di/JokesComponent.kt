package com.example.chucknorrisapp.di

import com.example.chucknorrisapp.MainActivity
import dagger.Component

@Component(modules =[
    ApplicationModule::class,
    NetworkModule::class
])
interface JokesComponent {

    fun inject(mainActivity: MainActivity)
}