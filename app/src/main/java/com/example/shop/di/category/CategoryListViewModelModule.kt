package com.example.shop.di.category

import androidx.lifecycle.ViewModel
import com.example.shop.ViewModel.CategoryListViewModel
import com.example.shop.ViewModel.ProductListViewModel
import com.example.shop.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CategoryListViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CategoryListViewModel::class)
    abstract fun passCategoryListViewModel(viewmodel: CategoryListViewModel): ViewModel
}