package com.example.shop.Repository

import com.example.shop.API.RetrofitInstance
import com.example.shop.API.ShopServices
import com.example.shop.API.ViewModel.BaseViewModel
import com.example.shop.API.ViewModel.CategoryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CategoryListRepository @Inject constructor(){

    fun getCategoryList(callBack: Callback<BaseViewModel<List<CategoryModel>>>) {
        val service: ShopServices = RetrofitInstance.getInstance().create(ShopServices::class.java)
        val call: Call<BaseViewModel<List<CategoryModel>>> = service.categoryList()
        call.enqueue(object : Callback<BaseViewModel<List<CategoryModel>>> {
            override fun onResponse(
                call: Call<BaseViewModel<List<CategoryModel>>>,
                response: Response<BaseViewModel<List<CategoryModel>>>
            ) {
                callBack.onResponse(call, response)
            }

            override fun onFailure(call: Call<BaseViewModel<List<CategoryModel>>>, t: Throwable) {

            }
        }
        )
    }
}