package com.aplicativo.topikotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplicativo.topikotlin.api.RetrofitInstance
import com.aplicativo.topikotlin.model.Lista
import com.aplicativo.topikotlin.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel(){

    val itemList = MutableLiveData<Lista>()

    fun getList() : MutableLiveData<Lista> = itemList

    fun loadUser(){
        viewModelScope.launch(Dispatchers.IO){
            val response = repository.ApiCall("ny")
            itemList.postValue(response)
        }
    }
}