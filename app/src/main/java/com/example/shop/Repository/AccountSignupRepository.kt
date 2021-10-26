package com.example.shop.Repository

import android.util.Log
import com.example.shop.API.RetrofitInstance
import com.example.shop.API.ShopServices
import com.example.shop.API.ViewModel.BaseViewModel
import com.example.shop.API.ViewModel.Member
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class AccountSignupRepository {
    @Inject
    lateinit var services:ShopServices
    @Inject
    constructor() {

    }

    fun sendCredentials(
        username: String,
        password: String,
        callBack: Callback<BaseViewModel<Member>>
    ) {

        val call: Call<BaseViewModel<Member>> = this.services.signUp(username, password)
        call.enqueue(object : Callback<BaseViewModel<Member>> {
            override fun onResponse(
                call: Call<BaseViewModel<Member>>,
                response: Response<BaseViewModel<Member>>
            ) {
                if (response.isSuccessful) {
                    callBack.onResponse(call, response)

                } else {
                    Log.i("LOG313", "")
                }

            }

            override fun onFailure(call: Call<BaseViewModel<Member>>, t: Throwable) {
                Log.i("LOG313", t.message)

            }
        }
        )
    }
}