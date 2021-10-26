package com.example.shop.Adapters

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.DB.Entity.Product
import com.example.shop.R
import com.example.shop.View.ShopCard
import com.example.shop.ViewModel.ShopCardViewModel
import javax.inject.Inject

class CardListAdapter @Inject constructor(val context: Application): RecyclerView.Adapter<CardListAdapter.ViewHolder>() {
    lateinit var Data:List<Product>
    lateinit var cardShopViewModel:ShopCardViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout._one_card_row, parent, false))
    }

    override fun getItemCount(): Int {
        return Data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_card_row_count.text = Data[position].count.toString()
        holder.txt_card_row_price.text = Data[position].price.toString()
        holder.txt_card_row_title.text = Data[position].title
        holder.txt_card_row_index.text = (position+1).toString()
        holder.img_card_row_increase.setOnClickListener({
            cardShopViewModel.increaseOneCard(Data[position])
        })
        holder.img_card_row_decrease.setOnClickListener({
            cardShopViewModel.decreaseOneCard(Data[position])

        })
    }

    fun passData(data:List<Product> ,cardShopCard:ShopCardViewModel){
        this.Data = data
        this.cardShopViewModel = cardShopCard
        this.notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_card_row_title: TextView
        var txt_card_row_index: TextView
        var txt_card_row_price: TextView
        var txt_card_row_count: TextView
        var img_card_row_increase: ImageView
        var img_card_row_decrease: ImageView

        init {
            txt_card_row_title = itemView.findViewById(R.id.txt_card_row_title)
            txt_card_row_index = itemView.findViewById(R.id.txt_card_row_index)
            txt_card_row_price = itemView.findViewById(R.id.txt_card_row_price)
            txt_card_row_count = itemView.findViewById(R.id.txt_card_row_count)
            img_card_row_increase = itemView.findViewById(R.id.img_card_row_increase)
            img_card_row_decrease = itemView.findViewById(R.id.img_card_row_decrease)
        }
    }
}