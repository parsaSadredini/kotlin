package com.example.shop.Repository

import android.util.Log
import com.example.shop.API.RetrofitInstance
import com.example.shop.API.ShopServices
import com.example.shop.API.ViewModel.BaseViewModel
import com.example.shop.API.ViewModel.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ProductListRepository @Inject constructor(){

    fun getProductList(categoryId: Int,callBack :Callback<BaseViewModel<List<ProductModel>>>) {
        val service : ShopServices = RetrofitInstance.getInstance().create(ShopServices::class.java)
        val call : Call<BaseViewModel<List<ProductModel>>> = service.productList(category = categoryId.toString())
        call.enqueue(object:Callback<BaseViewModel<List<ProductModel>>>{

            override fun onFailure(call: Call<BaseViewModel<List<ProductModel>>>, t: Throwable) {
                Log.i("LOG313","failed")
            }

            override fun onResponse(
                call: Call<BaseViewModel<List<ProductModel>>>,
                response: Response<BaseViewModel<List<ProductModel>>>
            ) {
                callBack.onResponse(call,response)
            }

        })
    }
}