package com.aplicativo.topikotlin.di.component

import com.aplicativo.topikotlin.MainActivity
import com.aplicativo.topikotlin.di.module.RetrofitModule
import com.aplicativo.topikotlin.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, ViewModelModule::class])
interface RetrofitComponent {
    fun inject(activity: MainActivity)
}