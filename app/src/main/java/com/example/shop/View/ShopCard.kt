package com.example.shop.View


import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shop.Adapters.CardListAdapter

import com.example.shop.DB.Entity.Product
import com.example.shop.ViewModel.ShopCardViewModel

import com.example.shop.R
import com.example.shop.ViewModel.ProductListViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_shop_card.*
import javax.inject.Inject


class ShopCard: DaggerFragment(){
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory
    @Inject
    lateinit var cardListAdapter:CardListAdapter

    lateinit var mViewModel:ShopCardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view_ = inflater.inflate(R.layout.fragment_shop_card, container, false)
        mViewModel = ViewModelProviders.of(this,providerFactory).get(ShopCardViewModel::class.java!!)
        initView()

        return view_
    }

    override fun onResume() {
        super.onResume()
        mViewModel!!.getShopCards()
    }


     fun initView() {
         mViewModel!!.getData().observe(this,Observer{ cardList->
             cardListAdapter.passData(cardList,mViewModel!!)
             rcv_card_list.adapter = cardListAdapter
             rcv_card_list.layoutManager= LinearLayoutManager(context!!)
         })
        mViewModel!!.getMessage_().observe(this, Observer { message->
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
        })
    }

}
