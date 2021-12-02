package com.aplicativo.topikotlin

import android.app.Application
import com.aplicativo.topikotlin.di.component.DaggerRetrofitComponent
import com.aplicativo.topikotlin.di.component.RetrofitComponent
import com.aplicativo.topikotlin.di.module.RetrofitModule

class MainApplication : Application(){

    private lateinit var retrofitComponent: RetrofitComponent

    override fun onCreate() {
        super.onCreate()

        retrofitComponent = DaggerRetrofitComponent.builder()
            .retrofitModule(RetrofitModule())
            .build()
    }

    fun getComponent() : RetrofitComponent = retrofitComponent
}