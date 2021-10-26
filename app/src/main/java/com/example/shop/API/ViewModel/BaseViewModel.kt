package com.example.shop.API.ViewModel

open class BaseViewModel<T>{
    var isSucces:Boolean = false
    var apiResultStatusCode :Int= -1
    var message:String = ""
    var Data:T? = null
    constructor(isSucces:Boolean,apiResultStatusCode:Int,message:String , Data:T?){
        this.isSucces = isSucces
        this.apiResultStatusCode = apiResultStatusCode
        this.message = message
        this.Data = Data
    }
    constructor()
}
