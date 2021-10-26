package com.example.shop.View


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shop.API.ViewModel.CategoryModel
import com.example.shop.Adapters.ProductListAdapter
import com.example.shop.R
import com.example.shop.ViewModel.ProductListViewModel
import com.example.shop.di.AppComponent
import com.example.shop.di.BaseApplication
import com.example.shop.di.DaggerAppComponent
import dagger.android.support.DaggerFragment
import dagger.multibindings.IntKey
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class Main : DaggerFragment(){
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory
    @Inject
    lateinit var productListAdapter: ProductListAdapter

    lateinit var mViewModel: ProductListViewModel

    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view_=inflater.inflate(R.layout.fragment_main, container, false)

        mViewModel = ViewModelProviders.of(this,providerFactory).get(ProductListViewModel::class.java!!)


        initView()
        return view_
    }

    fun initView() {
        val categoryListFragment : CategoryList= DaggerAppComponent.builder()
            .application(activity!!.application).build()
            .getCategoryComponent().productList(mViewModel).build().getCategoryListFragment()
//            .categoryList(mutableListOf<CategoryModel>())

        activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.frg_container_category_list, categoryListFragment)
            .commitAllowingStateLoss()

        mViewModel!!.getData().observe(this,Observer{productList->
            productListAdapter.passData(productList)
            rcv_product_list.adapter = productListAdapter
            rcv_product_list.layoutManager = LinearLayoutManager(context!!)
        })

    }



}
