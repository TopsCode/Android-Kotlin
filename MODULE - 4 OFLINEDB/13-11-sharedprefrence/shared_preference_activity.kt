package com.example.sharedprefrenceex

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity()
{

        lateinit var edtname:EditText
        lateinit var edtpass:EditText
        lateinit var btnlogin:Button
        lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtname=findViewById(R.id.edtname)
        edtpass=findViewById(R.id.edtpass)
        btnlogin=findViewById(R.id.btnlogin)
        sharedPreferences=getSharedPreferences("TOPS", MODE_PRIVATE)


        if (sharedPreferences.getBoolean("session", false) && !sharedPreferences.getString("name", "")!!.isEmpty())
        {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
            finish()
        }




        btnlogin.setOnClickListener()
        {
            var name=edtname.text.toString()
            var pass=edtpass.text.toString()

            var editor:SharedPreferences.Editor=sharedPreferences.edit()
            editor.putString("name",name)
            editor.putString("pass",pass)
            sharedPreferences.edit().putBoolean("session",true).commit();
            editor.apply()
            editor.commit()

            val intent=Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)


        }

    }
}