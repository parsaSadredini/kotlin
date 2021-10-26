package com.example.shop.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shop.Adapters.CategoryListAdapter
import com.example.shop.ViewModel.CategoryListViewModel
import kotlinx.android.synthetic.main.fragment_category_list.*
import androidx.lifecycle.ViewModelProviders
import com.example.shop.R
import com.example.shop.ViewModel.ProductListViewModel
import com.example.shop.di.DaggerAppComponent
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Named


class CategoryList @Inject constructor(@Named("productViewModel") val productViewModel :ProductListViewModel): DaggerFragment()  {
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory
    @Inject
    lateinit var categoryListAdapter: CategoryListAdapter


    lateinit var mViewModel :CategoryListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view_:View= inflater.inflate(R.layout.fragment_category_list, container, false)

        mViewModel = ViewModelProviders.of(this,providerFactory).get(CategoryListViewModel::class.java!!)
        mViewModel!!.getCategoryList()

        initView()

        return view_
    }

    fun initView(){
        mViewModel!!.getData().observe(this, Observer { categoryList ->
            categoryListAdapter.passDate(categoryList,productViewModel)
            rcv_category_list.adapter = categoryListAdapter
            val layutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rcv_category_list.layoutManager = layutManager
        })
    }


}
