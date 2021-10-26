package com.example.shop.di

import com.example.shop.View.Main
import com.example.shop.View.MainActivity
import com.example.shop.View.ShopCard
import com.example.shop.View.Signup
import com.example.shop.di.main.MainActivityModule
import com.example.shop.di.main.MainViewModelModule
import com.example.shop.di.main.ShopCardViewModelModule
import com.example.shop.di.signup.AccountSignupViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    //all the activities which have any injection should be added here
    @ContributesAndroidInjector(modules = [AccountSignupViewModelModule::class])
    abstract fun injectSignupActivity(): Signup

    @ContributesAndroidInjector(modules = [ MainActivityModule::class])
    abstract fun injectMainActivity(): MainActivity



}
