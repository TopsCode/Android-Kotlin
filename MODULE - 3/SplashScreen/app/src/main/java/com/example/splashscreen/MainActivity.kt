package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Handler().postDelayed({
//                              var i =Intent(this@MainActivity,SecondActivity::class.java);
//            startActivity(i);
//            finish();
//        },3000);


        Handler(Looper.getMainLooper()).postDelayed({
            var i = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}