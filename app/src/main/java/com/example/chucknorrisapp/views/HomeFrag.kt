package com.example.chucknorrisapp.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chucknorrisapp.JokesApp
import com.example.chucknorrisapp.R
import com.example.chucknorrisapp.databinding.FragmentHomeBinding
import com.example.chucknorrisapp.model.Jokes
import com.example.chucknorrisapp.rest.JokesRepo
import com.example.chucknorrisapp.utils.JokesState
import com.example.chucknorrisapp.viewmodel.JokesViewModel
import com.example.chucknorrisapp.viewmodel.JokesViewModelFactory
import javax.inject.Inject

class HomeFrag : Fragment() {

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var jokesRepo: JokesRepo

    private val jokesViewModel by lazy {
        ViewModelProvider(requireActivity(), JokesViewModelFactory(jokesRepo))[JokesViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        JokesApp.jokesComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        jokesViewModel.jokesLiveData.observe(viewLifecycleOwner) {
            when(it) {
                is JokesState.SUCCESS<*> -> {
                    AlertDialog.Builder(requireContext())
                        .setTitle("Random Joke")
                        .setMessage((it.jokes as Jokes).joke)
                        .setPositiveButton("DISMISS") { dialogInterface, i ->
                            dialogInterface.dismiss()
                        }
                        .create()
                        .show()
                }
            }
        }

        binding.randomJokeBtn.setOnClickListener {
            jokesViewModel.getRandomJoke()
        }

        binding.changeNameBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFrag_to_changeNameFrag)
        }

        binding.neverendingListBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFrag_to_neverendingListFrag)
        }

        return binding.root
    }
}