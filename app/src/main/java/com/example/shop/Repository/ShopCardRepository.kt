package com.example.shop.Repository

import com.example.shop.DB.DbAffairs
import com.example.shop.DB.Entity.Product
import javax.inject.Inject

class ShopCardRepository{

    @Inject
    lateinit var db:DbAffairs

    @Inject
    constructor(){

    }

     fun getShopCards(): List<Product>{
        return db.getAllProduct()
    }

     fun increaseOneCard(product: Product) {
        db.insertProduct(product)
    }

     fun decreaseOneCard(product: Product) {
        db.decreaseProduct(product)
    }
}