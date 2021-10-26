package com.example.shop.API.ViewModel

data class ProductModel(var id:Int,var Name:String,var ImageUrl:String,var Price:Double,var OperatorId:Int,
                        var CategoryId:Int,var created_at:String,var updated_at:String) {
}