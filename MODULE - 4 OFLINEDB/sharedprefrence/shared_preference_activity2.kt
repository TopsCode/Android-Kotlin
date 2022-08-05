package com.example.sharedprefrenceex

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity()
{
    lateinit var txt1:TextView
    lateinit var btn:Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        txt1=findViewById(R.id.txt1)
        btn=findViewById(R.id.btnlogout)
        sharedPreferences=getSharedPreferences("TOPS", MODE_PRIVATE)
        txt1.setText("welcome "+sharedPreferences.getString("name","default value"))
        btn.setOnClickListener()
        {

            sharedPreferences.edit().clear().commit()

            val intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)


        }

    }
}