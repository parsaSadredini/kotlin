package com.example.shop.di.signup

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.shop.ViewModel.AccountSignupViewModel
import com.example.shop.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AccountSignupViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AccountSignupViewModel::class)
    abstract fun passAccountsignupViewModel(viewmodel:AccountSignupViewModel): ViewModel
}