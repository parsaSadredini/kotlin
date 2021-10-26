package com.example.shop.Adapters

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.API.ViewModel.CategoryModel
import com.example.shop.R
import com.example.shop.View.CategoryList
import com.example.shop.ViewModel.ProductListViewModel
import javax.inject.Inject
import javax.inject.Named

class CategoryListAdapter @Inject constructor(val context : Application) : RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {

    lateinit var Data:List<CategoryModel>
    lateinit var productViewModel:ProductListViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.category_list_row, parent, false))
    }


    override fun getItemCount(): Int {
        return Data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_title.text = Data.get(position).title
        holder.txt_title.setOnClickListener({View ->
            productViewModel.getProductList(Data.get(position).id)
        })
    }

    fun passDate(data:List<CategoryModel>,productViewModel :ProductListViewModel){
        this.Data = data
        this.productViewModel = productViewModel
        this.notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var txt_title: TextView
            init {
                txt_title = itemView.findViewById(R.id.txt_category_row_title)
            }
    }

}