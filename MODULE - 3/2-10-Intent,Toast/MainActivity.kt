package com.example.firstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{

    //declaration
    lateinit var text :TextView
    lateinit var image:ImageView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialization


        text=findViewById(R.id.text1)
        image=findViewById(R.id.img1)


        text.setOnClickListener()
        {
           Toast.makeText(applicationContext,"success",Toast.LENGTH_LONG).show()

            //explicit
            val i=Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)

        }
        image.setOnClickListener()
        {
            Toast.makeText(applicationContext,"image downloaded",Toast.LENGTH_LONG).show()
            //implicit
            val url="https://www.tops-int.com"
            val i =Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }


    }
}