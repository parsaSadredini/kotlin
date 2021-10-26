package com.example.shop.di

import com.example.shop.View.CategoryList
import com.example.shop.View.Main
import com.example.shop.View.ShopCard
import com.example.shop.di.category.CategoryListViewModelModule
import com.example.shop.di.main.MainViewModelModule
import com.example.shop.di.main.ShopCardModule
import com.example.shop.di.main.ShopCardViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    //all fragments must be added here
    @ContributesAndroidInjector(modules = [MainViewModelModule::class])
    abstract fun injectMainContentFragment(): Main

    @ContributesAndroidInjector(modules = [ShopCardViewModelModule::class,ShopCardModule::class])
    abstract fun injectShopCardContentFragment(): ShopCard

    @ContributesAndroidInjector(modules = [CategoryListViewModelModule::class])
    abstract fun injectCategoryListFragment(): CategoryList

}