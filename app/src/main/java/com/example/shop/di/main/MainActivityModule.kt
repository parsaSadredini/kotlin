package com.example.shop.di.main

import com.example.shop.View.CategoryList
import com.example.shop.View.Main
import com.example.shop.View.ShopCard
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Module
    companion object{
        @Provides
        @JvmStatic
        fun provideMainFragment():Main{
            return Main()
        }
        @Provides
        @JvmStatic
        fun provideShopCardFragment():ShopCard{
            return ShopCard()
        }
    }
}