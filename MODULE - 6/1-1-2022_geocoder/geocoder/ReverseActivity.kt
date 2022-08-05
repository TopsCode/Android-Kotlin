package com.example.firstapp

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ReverseActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn:Button


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse)

        edt1=findViewById(R.id.edtl1)
        edt2=findViewById(R.id.edtl2)
        btn=findViewById(R.id.btn1)

        btn.setOnClickListener()
        {

            var n1:Double=edt1.text.toString().toDouble()
            var n2:Double=edt2.text.toString().toDouble()

            try
            {
                var geocoder=Geocoder(applicationContext)
                val list:List<Address> = geocoder.getFromLocation(n1,n2,1)

                val address:Address=list.get(0)

                Toast.makeText(applicationContext,""+address.locality+address.subAdminArea+address.adminArea+address.countryName+address.countryCode,Toast.LENGTH_LONG).show()


            }
            catch (e:Exception)
            {
                e.printStackTrace()
            }



        }




    }
}