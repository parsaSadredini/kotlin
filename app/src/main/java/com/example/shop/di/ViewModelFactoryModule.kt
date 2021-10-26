package com.example.shop.di

import androidx.lifecycle.ViewModelProvider
import com.example.shop.ViewModel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun viewModelFactoryBinder(viewmodel: ViewModelProviderFactory):ViewModelProvider.Factory
}