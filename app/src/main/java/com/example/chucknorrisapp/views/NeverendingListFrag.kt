package com.example.chucknorrisapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chucknorrisapp.JokesApp
import com.example.chucknorrisapp.R
import com.example.chucknorrisapp.adapter.JokesAdapter
import com.example.chucknorrisapp.databinding.FragmentHomeBinding
import com.example.chucknorrisapp.databinding.FragmentNeverendingListBinding
import com.example.chucknorrisapp.model.Jokes
import com.example.chucknorrisapp.rest.JokesRepo
import com.example.chucknorrisapp.utils.JokesState
import com.example.chucknorrisapp.viewmodel.JokesViewModel
import com.example.chucknorrisapp.viewmodel.JokesViewModelFactory
import retrofit2.Response
import javax.inject.Inject

class NeverendingListFrag : Fragment() {

    @Inject
    lateinit var jokesRepo: JokesRepo

    private val jokesViewModel by lazy {
        ViewModelProvider(requireActivity(), JokesViewModelFactory(jokesRepo))[JokesViewModel::class.java]
    }

    private val binding by lazy {
        FragmentNeverendingListBinding.inflate(layoutInflater)
    }

    private val jokesAdapter by lazy {
        JokesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        JokesApp.jokesComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.neverendingRecView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = jokesAdapter
        }

        jokesViewModel.jokesLiveData.observe(viewLifecycleOwner) { state ->
            when(state) {
                is JokesState.LOADING -> {
                    Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_LONG).show()
                }
                is JokesState.SUCCESS<*> -> {
                    jokesAdapter.setData(state.jokes as List<Jokes>)
                }
                is JokesState.ERROR -> {
                    Toast.makeText(requireContext(), state.error.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }

        return binding.root
    }
}