package com.example.shop.di

import android.app.Application
import com.example.shop.API.ShopServices
import com.example.shop.DB.DbAffairs
import com.example.shop.G
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideRetrofitInstance(): Retrofit {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            return Retrofit.Builder().baseUrl(G.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
        }

        @JvmStatic
        @Provides
        fun provideRetrofitShopService(retrofit: Retrofit): ShopServices {
            return retrofit.create(ShopServices::class.java);
        }

        @Provides
        @JvmStatic
        @Singleton
        fun provideDbAffairs(app: Application): DbAffairs {
            return DbAffairs(app)
        }
    }
}