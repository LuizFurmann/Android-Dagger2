package com.aplicativo.topikotlin.repository

import com.aplicativo.topikotlin.api.RetrofitService
import javax.inject.Inject

class MainRepository @Inject constructor(private val getServiceInstance: RetrofitService){

    suspend fun ApiCall(query: String) = getServiceInstance.getAllUser(query)
}