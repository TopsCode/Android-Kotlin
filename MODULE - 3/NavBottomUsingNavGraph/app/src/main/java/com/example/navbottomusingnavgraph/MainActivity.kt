package com.example.navbottomusingnavgraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bnv=findViewById<BottomNavigationView>(R.id.bnv)

        var navController=findNavController(R.id.fragmentContainerView)
        bnv.setupWithNavController(navController)
    }
}