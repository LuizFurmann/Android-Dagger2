package com.aplicativo.topikotlin.presenter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aplicativo.topikotlin.MainApplication
import com.aplicativo.topikotlin.model.Lista
import com.aplicativo.topikotlin.data.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel(application: Application) : AndroidViewModel(application){

    @Inject
    lateinit var mainRepository : MainRepository

    private var itemList : MutableLiveData<Lista>

    init {
        (application as MainApplication).getComponent().inject(this)
        itemList = MutableLiveData()
    }

    fun getList() : MutableLiveData<Lista> = itemList

    fun loadListUser(){
        viewModelScope.launch(Dispatchers.IO){
            val response = mainRepository.ApiCall("ny")
            itemList.postValue(response)
        }
    }
}