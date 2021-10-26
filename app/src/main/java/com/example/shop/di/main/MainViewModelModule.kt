package com.example.shop.di.main

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.shop.Adapters.ProductListAdapter
import com.example.shop.View.CategoryList
import com.example.shop.ViewModel.ProductListViewModel
import com.example.shop.ViewModel.ShopCardViewModel
import com.example.shop.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProductListViewModel::class)
    abstract fun passProductListViewModel(viewmodel: ProductListViewModel): ViewModel

    @Module
    companion object{

    }


}