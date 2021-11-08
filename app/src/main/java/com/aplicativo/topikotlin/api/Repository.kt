package com.aplicativo.topikotlin.api

import androidx.lifecycle.MutableLiveData
import com.aplicativo.topikotlin.model.Lista
import com.aplicativo.topikotlin.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val getServiceInstance: RetrofitService) {

    fun Apicall(query: String, liveDataList: MutableLiveData<List<User>>) {
        val call: Call<Lista> = getServiceInstance.getAllUser(query)
        call?.enqueue(object : Callback<Lista> {
            override fun onFailure(call: Call<Lista>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<Lista>, response: Response<Lista>) {
                liveDataList.postValue(response.body()?.items!!)
            }
        })
    }
}