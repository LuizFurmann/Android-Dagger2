package com.aplicativo.topikotlin.data

import com.aplicativo.topikotlin.data.api.RetrofitService
import javax.inject.Inject

class MainRepository @Inject constructor(private val getServiceInstance: RetrofitService){

    suspend fun ApiCall(query: String) = getServiceInstance.getAllUser(query)
}