package com.example.chucknorrisapp.di

import com.example.chucknorrisapp.MainActivity
import com.example.chucknorrisapp.views.ChangeNameFrag
import com.example.chucknorrisapp.views.HomeFrag
import com.example.chucknorrisapp.views.NeverendingListFrag
import dagger.Component

@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class
])
interface JokesComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(homeFrag: HomeFrag)
    fun inject(neverendingListFrag: NeverendingListFrag)
    fun inject(changeNameFrag: ChangeNameFrag)
}