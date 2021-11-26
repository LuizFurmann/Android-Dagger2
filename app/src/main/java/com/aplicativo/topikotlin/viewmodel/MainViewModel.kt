package com.aplicativo.topikotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplicativo.topikotlin.api.RetrofitInstance
import com.aplicativo.topikotlin.model.Lista
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    val itemList = MutableLiveData<Lista>()

    fun getList() : MutableLiveData<Lista> = itemList

    fun loadUser(){
        viewModelScope.launch(Dispatchers.IO){
            val retroInstance = RetrofitInstance.getInstance
            val response = retroInstance.getAllUser("ny")
            itemList.postValue(response)
        }
    }
}