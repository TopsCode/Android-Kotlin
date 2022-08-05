package com.example.retrofitcrudex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn:Button

    var name=""
    var email=""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        edt1=findViewById(R.id.edtname)
        edt2=findViewById(R.id.edtemail)
        btn=findViewById(R.id.btn1)

        val i=intent
         var id=i.getIntExtra("id",0)!!
         name= i.getStringExtra("name")!!
         email= i.getStringExtra("email")!!

        edt1.setText(name)
        edt2.setText(email)


        btn.setOnClickListener()
        {

            Toast.makeText(applicationContext,""+id,Toast.LENGTH_LONG).show()
             name=edt1.text.toString()
             email=edt2.text.toString()

            val tops:Apiinterface= ApiClient().getApiClient()!!.create(Apiinterface::class.java)

            val call: Call<Model?>? =tops.updatedata(id.toString(),name,email)
            call!!.enqueue(object : Callback<Model?> {
                override fun onResponse(call: Call<Model?>, response: Response<Model?>)
                {
                    // val result: String = java.lang.String.valueOf(response.body())
                    Toast.makeText(applicationContext, "product Updated", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Model?>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"No Intrenet", Toast.LENGTH_LONG).show()
                }
            })
            /* val i =Intent(applicationContext,ViewActivity::class.java)
             startActivity(i)

 */
            startActivity(Intent(this, MainActivity2::class.java))
        }

    }
}