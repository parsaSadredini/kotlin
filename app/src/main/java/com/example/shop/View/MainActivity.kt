package com.example.shop.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.shop.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(){
    @Inject
    lateinit var main:Main
    @Inject
    lateinit var shopCard:ShopCard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title=resources.getString(R.string.store)
        loadFragment(this.main)

        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_store-> {
                    title=resources.getString(R.string.store)
                    loadFragment(this.main)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_shop_card-> {
                    title=resources.getString(R.string.shop_card)
                    loadFragment(this.shopCard)
                    return@setOnNavigationItemSelectedListener true
                }



            }
            false

        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
