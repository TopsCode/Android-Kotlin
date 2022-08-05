package com.example.fragmentex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn1.setOnClickListener()
        {
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener()
        {
            myfragment(Fragment1())
        }
    }

    private fun myfragment(fragment1: Fragment1)
    {
           val fm:FragmentManager=supportFragmentManager
           val ft:FragmentTransaction=fm.beginTransaction()
            ft.replace(R.id.frmid,fragment1).commit()
    }
}