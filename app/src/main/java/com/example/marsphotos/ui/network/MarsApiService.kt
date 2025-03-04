package com.example.marsphotos.ui.network

import retrofit.Call
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.http.Path
import retrofit2.http.GET

private const val BASE_URL =
    "https://www.freetogame.com/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

class MarsApiService {

    interface MarsApiService {
        @GET("games")
        suspend fun getGames(): List<Games>
    }

    object MarsApi {
        val retrofitService : MarsApiService by lazy {
            retrofit.create(MarsApiService::class.java)
        }
    }

}
