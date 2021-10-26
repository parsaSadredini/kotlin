package com.example.shop.di.main

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.shop.DB.DbAffairs
import com.example.shop.Repository.ShopCardRepository
import com.example.shop.ViewModel.ShopCardViewModel
import com.example.shop.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ShopCardViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ShopCardViewModel::class)
    abstract fun passShopCardViewModel(viewmodel: ShopCardViewModel): ViewModel

//
}