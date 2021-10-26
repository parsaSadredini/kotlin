package com.example.shop.API

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// this manner is obsolete through Dagger
class RetrofitInstance {
    companion object {
        private var retrofit: Retrofit? = null

        private val BASE_URL = "http://10.0.2.2:8080/shop/api/"
        fun getInstance():Retrofit{
            if (this.retrofit == null) {
                val gson = GsonBuilder()
                    .setLenient()
                    .create()
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit!!

        }
    }


}