package com.aplicativo.topikotlin.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aplicativo.topikotlin.di.ViewModelFactory
import com.aplicativo.topikotlin.di.ViewModelKey
import com.aplicativo.topikotlin.presenter.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun postListViewModel(viewModel: MainViewModel): ViewModel
}