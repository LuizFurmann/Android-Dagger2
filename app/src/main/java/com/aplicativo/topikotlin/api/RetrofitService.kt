package com.aplicativo.topikotlin.api

import com.aplicativo.topikotlin.model.Lista
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("repositories")
    suspend fun getAllUser(@Query("q") query: String) : Lista
}