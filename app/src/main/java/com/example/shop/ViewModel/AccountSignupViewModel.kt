package com.example.shop.ViewModel

import android.app.Application
import android.util.Log
import androidx.appcompat.view.menu.MenuPresenter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.shop.API.ViewModel.BaseViewModel
import com.example.shop.API.ViewModel.Member
import com.example.shop.Repository.AccountSignupRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AccountSignupViewModel:AndroidViewModel {
    @Inject
    lateinit var mRepository: AccountSignupRepository
    val signedUp = MutableLiveData<Boolean>()
    val message= MutableLiveData<String>()

    @Inject
    constructor(application: Application):super(application){
    }
    fun sendCredentials(username:String ,password:String) {
        mRepository.sendCredentials(username = username,password = password, callBack = object: Callback<BaseViewModel<Member>>{

            override fun onResponse(
                call: Call<BaseViewModel<Member>>,
                response: Response<BaseViewModel<Member>>
            ) {
                Log.i("LOG313",response.body()!!.isSucces.toString())
                if(response.body()!!.isSucces){
                    signedUp.value=true
                }else{
                    message.value=response.body()!!.message
                    signedUp.value=false
                }
            }

            override fun onFailure(call: Call<BaseViewModel<Member>>, t: Throwable) {
            }
        })
    }

    fun getData():MutableLiveData<Boolean>{
        return signedUp
    }
    fun getMessage_():MutableLiveData<String>{
        return message
    }

}