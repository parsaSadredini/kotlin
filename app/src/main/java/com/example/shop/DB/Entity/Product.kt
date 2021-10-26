package com.example.shop.DB.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "product_id") var ProductID: Int,
    @ColumnInfo(name="count") var count: Int,
    @ColumnInfo(name="price") var price: Double
)