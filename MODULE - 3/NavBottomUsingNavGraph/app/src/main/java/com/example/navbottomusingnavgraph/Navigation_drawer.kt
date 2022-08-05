package com.example.navbottomusingnavgraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class Navigation_drawer : AppCompatActivity() {
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        var toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        var drawlayout=findViewById<DrawerLayout>(R.id.drawerLayout)
        var navigationview=findViewById<NavigationView>(R.id.nav_view)
        var nav_controller=findNavController(R.id.fragmentContainerView2)
        appBarConfiguration=AppBarConfiguration(setOf(R.id.homeFragment,R.id.profileFragment,R.id.settingFragment),drawlayout)
        setupActionBarWithNavController(nav_controller,appBarConfiguration)
        navigationview.setupWithNavController(nav_controller)
    }

    override fun onSupportNavigateUp(): Boolean {
        var nav_controller=findNavController(R.id.fragmentContainerView2)

        return nav_controller.navigateUp(appBarConfiguration)|| super.onSupportNavigateUp()
    }
}