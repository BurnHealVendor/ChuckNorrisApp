package com.example.chucknorrisapp.rest

import com.example.chucknorrisapp.model.Jokes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesAPI {

    @GET(RANDOM_PATH)
    suspend fun getRandom(
        @Query("first_name") firstName: String = FIRST_NAME,
        @Query("last_name") lastName: String = LAST_NAME
    ): Response<Jokes>

    @GET(RANDOM_PATH)
    suspend fun getJokesList(
        @Query("first_name") firstName: String = FIRST_NAME,
        @Query("last_name") lastName: String = LAST_NAME
    ): Response<List<Jokes>>

    companion object {
        const val BASE_URL = "http://api.icndb.com/jokes/"
        private const val RANDOM_PATH = "random"
        private const val FIRST_NAME = "First Name"
        private const val LAST_NAME = "Last Name"
    }
}