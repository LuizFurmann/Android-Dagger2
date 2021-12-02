package com.aplicativo.topikotlin.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplicativo.topikotlin.data.model.Lista
import com.aplicativo.topikotlin.data.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel(){

    val itemList = MutableLiveData<Lista>()

    fun getList() : MutableLiveData<Lista> = itemList

    fun loadListUser(){
        viewModelScope.launch(Dispatchers.IO){
            val response = mainRepository.ApiCall("ny")
            itemList.postValue(response)
        }
    }
}