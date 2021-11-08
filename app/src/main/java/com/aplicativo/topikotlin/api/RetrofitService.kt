package com.aplicativo.topikotlin.api

import com.aplicativo.topikotlin.model.Lista
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("repositories")
    fun getAllUser(@Query("q")query: String): Call<Lista>
}