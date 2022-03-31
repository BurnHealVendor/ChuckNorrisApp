package com.example.chucknorrisapp.model


import com.google.gson.annotations.SerializedName

data class Jokes(
    @SerializedName("categories")
    val categories: List<Any>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("joke")
    val joke: String
)