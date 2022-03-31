package com.example.chucknorrisapp.rest

import com.example.chucknorrisapp.model.Jokes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesAPI {

    @GET(RANDOM_PATH)
    suspend fun  getRandom(
        @Query("random") id: Int
    ): Response<List<Jokes>>

    companion object {
        const val BASE_URL = "http://api.icndb.com/jokes/"
        private const val RANDOM_PATH = "random"
    }
}