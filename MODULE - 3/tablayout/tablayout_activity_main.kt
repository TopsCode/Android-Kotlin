package com.example.tablayoutex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
{

    lateinit var toolbar: Toolbar
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     toolbar=findViewById(R.id.tool)
     setSupportActionBar(toolbar)

     viewPager=findViewById(R.id.view1)
     setupviewpager()

      tabLayout=findViewById(R.id.tab)
      tabLayout.setupWithViewPager(viewPager)




    }

    private fun setupviewpager()
    {

        val myAdapter1=MyAdapter1(supportFragmentManager)
        myAdapter1.adddata("Chat",ChatFragment())
        myAdapter1.adddata("Status",StatusFragment())
        myAdapter1.adddata("Call",CallFragment())
        view1.adapter=myAdapter1

    }
}