package com.example.shop.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.shop.DB.Entity.Product
import com.example.shop.Repository.ShopCardRepository
import com.example.shop.View.ShopCard
import java.lang.Exception
import javax.inject.Inject

class ShopCardViewModel:AndroidViewModel {

    var mRepository :ShopCardRepository

    val cardListData = MutableLiveData<List<Product>>()
    val message= MutableLiveData<String>()
    @Inject
    constructor(repose :ShopCardRepository,application :Application):super(application){
        this.mRepository = repose
        getShopCards()
    }

    fun getShopCards() {
        cardListData.value = mRepository.getShopCards()
    }

    fun increaseOneCard(product: Product) {
        try {
            mRepository.increaseOneCard(product)
            this.getShopCards()
        }catch (ex:Exception){
            message.value="Something went wrong!"
        }
    }

     fun decreaseOneCard(product: Product) {
        try {
            mRepository.decreaseOneCard(product)
            this.getShopCards()
        }catch (ex:Exception){
            message.value="Something went wrong!"
        }
    }
    fun getData():MutableLiveData<List<Product>>{
        return cardListData
    }

    fun getMessage_():MutableLiveData<String>{
        return message
    }
}