package com.example.chucknorrisapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chucknorrisapp.JokesApp
import com.example.chucknorrisapp.R
import com.example.chucknorrisapp.databinding.FragmentChangeNameBinding
import com.example.chucknorrisapp.databinding.FragmentHomeBinding

class ChangeNameFrag : Fragment() {

    private val binding by lazy {
        FragmentChangeNameBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        JokesApp.jokesComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return binding.root
    }
}