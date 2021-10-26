package com.example.shop.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RestrictTo
import androidx.lifecycle.lifecycleScope
import com.example.shop.R
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//        Thread{
//            Thread.sleep(5000)
//            val i = Intent(this@Splash, Signup::class.java)
//            startActivity(i)
//        }.start()


            GlobalScope.launch {
                delay(5000)
                val i = Intent(this@Splash, Signup::class.java)
                startActivity(i)
            }



        txv_splash.setOnClickListener {
            // it does not stop anything
//            GlobalScope.launch {
//                while (true){
//
//                }
//            }
            // you have to join the reuslt in a blocking section...like any other language...proccess should be done in  any thread but the thread that runBlocking stops
//            var a= GlobalScope.async {
//                "hello"
//            }
//            var b = GlobalScope.async {
//                "parsa"
//            }
//            runBlocking {
//                Toast.makeText(this@Splash, "${a.await()} ${b.await()}", Toast.LENGTH_SHORT).show()
//            }

            var aa= lifecycleScope.async {
                "hello"
            }
            var bb = lifecycleScope.async {
                "parsa"
            }
            lifecycleScope.launch {
                Toast.makeText(this@Splash, "${aa.await()} ${bb.await()}", Toast.LENGTH_SHORT).show()
            }

        }

    }

    
}
