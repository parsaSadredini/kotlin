package com.example.shop.Adapters

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.API.ViewModel.ProductModel
import com.example.shop.DB.DbAffairs
import com.example.shop.DB.Entity.Product
import com.example.shop.R
import com.example.shop.Repository.ShopCardRepository
import com.example.shop.View.MainActivity
import javax.inject.Inject

class ProductListAdapter @Inject constructor(val context : Application,val db : ShopCardRepository) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    lateinit var Data:List<ProductModel>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.product_list_row, parent, false))

    }

    override fun getItemCount(): Int {
        return Data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_title.text = Data[position].Name

        holder.img_add_to_cart.setOnClickListener {
            db.increaseOneCard(Product(id=0,
                title = Data[position].Name,
                ProductID = Data[position].id,
                price = Data[position].Price,count = 1))
        }
    }

    fun passData(data:List<ProductModel>){
        this.Data=data
        this.notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_title: TextView
        var img_add_to_cart:ImageView
        init {
            txt_title = itemView.findViewById(R.id.txt_product_row_title)
            img_add_to_cart=itemView.findViewById(R.id.img_add_to_cart)
        }
    }
}