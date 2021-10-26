package com.example.shop.API

import com.example.shop.API.ViewModel.BaseViewModel
import com.example.shop.API.ViewModel.CategoryModel
import com.example.shop.API.ViewModel.Member
import com.example.shop.API.ViewModel.ProductModel
import retrofit2.Call
import retrofit2.http.*


public interface ShopServices {
    @GET("shop/category")
    fun categoryList(): Call<BaseViewModel<List<CategoryModel>>>

    @GET("shop/cats/products/{category}")
    fun productList(@Path("category") category:String):Call<BaseViewModel<List<ProductModel>>>

    @POST("member/signup")
    @FormUrlEncoded
    fun signUp(@Field("username") username :String , @Field("password") password:String): Call<BaseViewModel<Member>>
}