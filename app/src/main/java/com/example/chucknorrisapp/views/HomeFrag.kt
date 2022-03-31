package com.example.chucknorrisapp.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chucknorrisapp.JokesApp
import com.example.chucknorrisapp.R
import com.example.chucknorrisapp.databinding.FragmentHomeBinding

class HomeFrag : Fragment() {

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        JokesApp.jokesComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.randomJokeBtn.setOnClickListener() {
            AlertDialog.Builder(requireContext())
                .setTitle("Random Joke")
                .setMessage(jokesViewModel.getRandomJoke())
                .setPositiveButton("DISMISS") { dialogInterface, i ->
                    dialogInterface.dismiss()
                }
                .create()
                .show()
        }

        binding.changeNameBtn.setOnClickListener() {
            findNavController().navigate(R.id.action_homeFrag_to_changeNameFrag)
        }

        binding.neverendingListBtn.setOnClickListener() {
            findNavController().navigate(R.id.action_homeFrag_to_neverendingListFrag)
        }

        return binding.root
    }
}