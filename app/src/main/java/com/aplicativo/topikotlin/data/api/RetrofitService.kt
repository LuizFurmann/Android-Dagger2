package com.aplicativo.topikotlin.data.api

import com.aplicativo.topikotlin.data.model.Lista
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("repositories")
    suspend fun getAllUser(@Query("q") query: String) : Lista
}