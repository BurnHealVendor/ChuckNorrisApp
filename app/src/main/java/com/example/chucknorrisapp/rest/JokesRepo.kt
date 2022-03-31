package com.example.chucknorrisapp.rest

import com.example.chucknorrisapp.model.Jokes
import retrofit2.Response

interface JokesRepo {
    suspend fun getRandom(id: Int): Response<List<Jokes>>
}

class JokesRepoImpl(
    private val jokesAPI: JokesAPI
) : JokesRepo {

    override suspend fun getRandom(id: Int): Response<List<Jokes>> =
        jokesAPI.getRandom(id)
}