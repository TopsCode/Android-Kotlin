package com.example.myapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonexample.Model
import com.example.jsonexample.MyAdapter
import org.json.JSONArray
import org.json.JSONException

class ViewActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        listView = findViewById(R.id.list)
        list = ArrayList()


        val stringRequest = StringRequest(Request.Method.POST,Api2.VIEW, {
                    response ->
                try {
                    val jsonArray = JSONArray(response)
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val name = jsonObject.getString("product_name")
                        val price = jsonObject.getString("product_price")
                        val des = jsonObject.getString("product_description")
                        val quantity = jsonObject.getString("product_quantity")
                        val categoryModel = Model()
                        categoryModel.productname=name
                        categoryModel.productprice = price
                        categoryModel.productdescription=des
                        categoryModel.productquantity=quantity

                        list!!.add(categoryModel)
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
                val categoryAdapter = MyAdapter(this, list!!)
                listView.setAdapter(categoryAdapter)

            }
        ) { Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show() }

        val queue = Volley.newRequestQueue(this)
        queue.add(stringRequest)



    }
}