package com.aplicativo.topikotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aplicativo.topikotlin.api.Repository
import com.aplicativo.topikotlin.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel(){

        lateinit var listUser : MutableLiveData<List<User>>

    init{
        listUser = MutableLiveData()
    }

    fun getUser() : MutableLiveData<List<User>>{
        return listUser
    }
    fun loadListUser(){
        repository.Apicall("ny", listUser)
    }
}