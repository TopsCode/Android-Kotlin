package com.example.formexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    lateinit var txtname:TextView
    lateinit var btnlogout:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        txtname=findViewById(R.id.txtname)
        btnlogout=findViewById(R.id.btnlogout)


        val intent1=intent
        txtname.setText( "welcome "+intent1.getStringExtra("t1"))

        btnlogout.setOnClickListener()
        {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

}