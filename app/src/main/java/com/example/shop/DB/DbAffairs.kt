package com.example.shop.DB

import android.content.Context
import androidx.room.Room
import com.example.shop.DB.Entity.Product

class DbAffairs {
    val db:AppDatabase
    constructor(context:Context){
        db= AppDatabase.invoke(context)
    }
    fun insertProduct(product: Product){
        var mProduct :Product=  db.ProductDao().getById(product.ProductID)
        if(mProduct!=null){
            mProduct.count+=1
            db.ProductDao().updateTodo(mProduct)
        }else{
            db.ProductDao().insertAll(product)
        }

    }
    fun decreaseProduct(product: Product){
        var mProduct :Product=  db.ProductDao().getById(product.ProductID)
        if(mProduct!=null){
            mProduct.count-=1
            if(mProduct.count <= 0 ){
                db.ProductDao().delete(product)
            }else{
                db.ProductDao().updateTodo(mProduct)
            }
        }
    }
    fun getAllProduct():List<Product>{
        return db.ProductDao().getAll()
    }
}