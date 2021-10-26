package com.example.shop.DB.DAO

import androidx.room.*
import com.example.shop.DB.Entity.Product

@Dao
interface ProductDAO {

    @Query("SELECT * FROM Product")
    fun getAll(): List<Product>

    @Query("SELECT * FROM Product where product_id=:product_id limit 1")
    fun getById(product_id:Int): Product

    @Insert
    fun insertAll(vararg products: Product)

    @Delete
    fun delete(product: Product)

    @Update
    fun updateTodo(vararg products: Product)
}