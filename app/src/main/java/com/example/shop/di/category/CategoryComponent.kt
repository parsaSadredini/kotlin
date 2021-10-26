package com.example.shop.di.category

import com.example.shop.API.ViewModel.CategoryModel
import com.example.shop.Adapters.CategoryListAdapter
import com.example.shop.Adapters.ProductListAdapter
import com.example.shop.View.CategoryList
import com.example.shop.ViewModel.ProductListViewModel
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named

@Subcomponent(modules = [CategoryListViewModelModule::class])
interface CategoryComponent {

    fun getCategoryListFragment(): CategoryList


    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun productList(@Named("productViewModel") productList: ProductListViewModel): Builder
        fun build(): CategoryComponent
    }
}