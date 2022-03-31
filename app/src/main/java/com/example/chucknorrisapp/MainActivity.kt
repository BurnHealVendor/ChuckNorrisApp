package com.example.chucknorrisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisapp.rest.JokesRepo
import com.example.chucknorrisapp.viewmodel.JokesViewModel
import com.example.chucknorrisapp.viewmodel.JokesViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: JokesViewModelFactory
    lateinit var jokesRepo: JokesRepo

    private val myViewModel by lazy {
        ViewModelProvider(this, JokesViewModelFactory(jokesRepo))[JokesViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        JokesApp.jokesComponent.inject(this)
    }
}