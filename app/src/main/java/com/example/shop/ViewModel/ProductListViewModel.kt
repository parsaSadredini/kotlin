package com.example.shop.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.shop.API.ViewModel.BaseViewModel
import com.example.shop.API.ViewModel.CategoryModel
import com.example.shop.API.ViewModel.ProductModel
import com.example.shop.Repository.ProductListRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ProductListViewModel @Inject constructor(application:Application) :AndroidViewModel(application){
    @Inject
    lateinit var mRepository:ProductListRepository
    var productListData = MutableLiveData<List<ProductModel>>()


    fun getProductList(categoryId: Int) {
        mRepository.getProductList(categoryId,object: Callback<BaseViewModel<List<ProductModel>>>{

            override fun onResponse(
                call: Call<BaseViewModel<List<ProductModel>>>,
                response: Response<BaseViewModel<List<ProductModel>>>
            ) {
                productListData.value=response.body()!!.Data!!
            }
            override fun onFailure(call: Call<BaseViewModel<List<ProductModel>>>, t: Throwable) {

            }
        })
    }
    fun getData():MutableLiveData<List<ProductModel>>{
        return productListData
    }


}