package com.example.chucknorrisapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapp.databinding.JokeItemBinding
import com.example.chucknorrisapp.model.Jokes

class JokesAdapter(
    private val jokes: MutableList<Jokes> = mutableListOf()
) : RecyclerView.Adapter<JokesViewHolder>() {

    fun setData(newJokes: List<Jokes>) {
        jokes.clear()
        jokes.addAll(newJokes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        return JokesViewHolder(
            JokeItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) =
        holder.bind(jokes[position])

    override fun getItemCount(): Int = jokes.size
}

class JokesViewHolder(
    private val binding: JokeItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(jokes: Jokes) {
        binding.joke.text = jokes.joke
    }
}