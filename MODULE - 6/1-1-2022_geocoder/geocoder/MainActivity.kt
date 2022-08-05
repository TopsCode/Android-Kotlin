package com.example.firstapp

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var btn:Button
    lateinit var txt:TextView


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edt1=findViewById(R.id.edt1)
        btn=findViewById(R.id.btn1)
        txt=findViewById(R.id.txt)

        btn.setOnClickListener()
        {

            var data = edt1.text.toString()

            val geocoder=Geocoder(applicationContext)
            val list:List<Address> = geocoder.getFromLocationName(data,1)

            for (a in list)
            {
                val latti = a.latitude
                val longi = a.longitude
                txt.append("$latti,$longi")
            }



        }



    }
}