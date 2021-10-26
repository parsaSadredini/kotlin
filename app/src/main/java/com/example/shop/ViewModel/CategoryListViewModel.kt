package com.example.shop.ViewModel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.shop.API.ViewModel.BaseViewModel
import com.example.shop.API.ViewModel.CategoryModel
import com.example.shop.Repository.CategoryListRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class CategoryListViewModel @Inject constructor(application: Application):  AndroidViewModel(application) {
    @Inject
    lateinit var respository :CategoryListRepository
    var categoryListData = MutableLiveData<List<CategoryModel>>()

    fun getCategoryList() {
        respository.getCategoryList(object :Callback<BaseViewModel<List<CategoryModel>>>{
            override fun onResponse(
                call: Call<BaseViewModel<List<CategoryModel>>>,
                response: Response<BaseViewModel<List<CategoryModel>>>
            ) {
                categoryListData.value  = response.body()!!.Data
            }
            override fun onFailure(call: Call<BaseViewModel<List<CategoryModel>>>, t: Throwable) {

            }
        })

    }
    fun getData():MutableLiveData<List<CategoryModel>>{
        return categoryListData
    }

}