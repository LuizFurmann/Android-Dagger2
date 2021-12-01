package com.aplicativo.topikotlin.dagger.component

import com.aplicativo.topikotlin.dagger.module.RetrofitModule
import com.aplicativo.topikotlin.viewmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface RetrofitComponent {
    fun inject(mainViewModel: MainViewModel)
}