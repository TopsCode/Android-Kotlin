package com.example.retrofitcrudex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    lateinit var edt1: EditText
    lateinit var edt2:EditText
    lateinit var register: Button
    lateinit var txt:TextView


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1=findViewById(R.id.edtname)
        edt2=findViewById(R.id.edtemail)
        register=findViewById(R.id.btn1)
        txt=findViewById(R.id.txtview)

        register.setOnClickListener()
        {

            var name=edt1.text.toString()
            var email=edt2.text.toString()

            val tops:Apiinterface= ApiClient().getApiClient()!!.create(Apiinterface::class.java)

            val call: Call<Model?>? =tops.savedata(name,email)
            call!!.enqueue(object : Callback<Model?> {
                override fun onResponse(call: Call<Model?>, response: Response<Model?>)
                {
                   // val result: String = java.lang.String.valueOf(response.body())
                    Toast.makeText(this@MainActivity, "product added", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Model?>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"No Intrenet",Toast.LENGTH_LONG).show()
                }
            })
           /* val i =Intent(applicationContext,ViewActivity::class.java)
            startActivity(i)

*/
            startActivity(Intent(this, MainActivity2::class.java))


        }
        txt.setOnClickListener()
        {

            startActivity(Intent(this, MainActivity2::class.java))

        }


    }
}