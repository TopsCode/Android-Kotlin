package com.example.myapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.Nullable
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity()
{

    lateinit var productname: EditText
    lateinit var productprice: EditText
    lateinit var productquantity: EditText
    lateinit var productdescription:EditText
    lateinit var addproduct: Button


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productname = findViewById(R.id.edt1)
        productprice = findViewById(R.id.edt2)
        productquantity = findViewById(R.id.edt3)
        productdescription= findViewById(R.id.edt4)
        addproduct = findViewById(R.id.btnregister)

        addproduct.setOnClickListener()
        {

            val name = productname.text.toString()
            val price = productprice.text.toString()
            val quantity = productquantity.text.toString()
            val des=productdescription.text.toString()

            val stringrequest: StringRequest =
                object : StringRequest(Request.Method.POST, Api2.INSERT, Response.Listener
                {

                    Toast.makeText(this, "Product Added", Toast.LENGTH_SHORT).show()

                    val i=Intent(applicationContext,ViewActivity::class.java)
                    startActivity(i)

                }, Response.ErrorListener {

                    Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show()

                }
                ) {
                    @Nullable
                    @Throws(AuthFailureError::class)
                    override fun getParams(): HashMap<String, String> {
                        val map = HashMap<String, String>()
                        map["product_name"] = name
                        map["product_price"] = price
                        map["product_quantity"] = quantity
                        map["product_description"]=des

                        return map
                    }
                }
            val queue = Volley.newRequestQueue(this)
            queue.add(stringrequest)


        }
    }
}