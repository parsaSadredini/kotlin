package com.example.shop.di

import android.app.Application
import com.example.shop.View.Signup
import com.example.shop.di.category.CategoryComponent
import com.example.shop.di.main.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        ViewModelFactoryModule::class,
        AppModule::class,
        AndroidSupportInjectionModule::class // Important
    ]
)
@Singleton
interface AppComponent : AndroidInjector<BaseApplication> {
    fun getCategoryComponent(): CategoryComponent.Builder
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder


        fun build(): AppComponent
    }
}