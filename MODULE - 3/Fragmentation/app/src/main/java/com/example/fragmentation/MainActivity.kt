package com.example.fragmentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var container=findViewById<LinearLayout>(R.id.mainContainer)
        var btn=findViewById<Button>(R.id.btn)
        var et_send=findViewById<EditText>(R.id.et_send)

        var fragmentManager= supportFragmentManager
        var fragmentTransaction=fragmentManager.beginTransaction()

        var fragment= BlankFragment()


        btn.setOnClickListener {
            var bundle=Bundle()
            bundle.putString("mydata" , et_send.text.toString())
            fragment.arguments=bundle
            fragmentTransaction.add(R.id.mainContainer,fragment).commit();
        }
    }
}