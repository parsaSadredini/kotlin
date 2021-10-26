package com.example.shop.View

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.shop.R
import com.example.shop.ViewModel.AccountSignupViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_signin.*
import javax.inject.Inject


class Signup : DaggerAppCompatActivity() {
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory
    lateinit var mViewModel : AccountSignupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        mViewModel = ViewModelProviders.of(this,providerFactory).get(AccountSignupViewModel::class.java!!)
        initView()


        btn_signin.setOnClickListener{
            var username = txt_username.text.toString()
            var password = txt_password.text.toString()
            mViewModel!!.sendCredentials(username = username, password = password)
//            goToMainPage()
        }
    }


    fun initView(){
        mViewModel!!.getData().observe(this,Observer{isSignedUp->
            if(isSignedUp){
                var i = Intent(this,MainActivity::class.java)
                startActivity(i)
            }
        })

        mViewModel!!.getMessage_().observe(this,Observer{message->
            if(!message.equals("")){
                Toast.makeText(this,mViewModel!!.getMessage_().value,Toast.LENGTH_SHORT).show()
            }
        })

        (this as AppCompatActivity).supportActionBar!!.setTitle("Signup")
    }
}
