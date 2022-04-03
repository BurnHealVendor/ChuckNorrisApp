package com.example.chucknorrisapp.rest

import com.example.chucknorrisapp.model.Jokes
import retrofit2.Response
import javax.inject.Inject

interface JokesRepo {
    suspend fun getRandom(): Response<Jokes>
    suspend fun getJokesList(): Response<List<Jokes>>
}

class JokesRepoImpl @Inject constructor(
    private val jokesAPI: JokesAPI
) : JokesRepo {

    override suspend fun getRandom(): Response<Jokes> =
        jokesAPI.getRandom()

    override suspend fun getJokesList(): Response<List<Jokes>> =
        jokesAPI.getJokesList()

}