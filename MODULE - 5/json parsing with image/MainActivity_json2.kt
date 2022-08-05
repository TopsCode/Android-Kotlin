package com.example.jsonexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import java.util.ArrayList

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        val stringRequest = StringRequest(
            Request.Method.POST,"https://prakrutivyas.000webhostapp.com/regserver/viewproduct.php", {
                    response ->
                try {
                    val jsonArray = JSONArray(response)
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val name = jsonObject.getString("productname")
                        val price = jsonObject.getString("productprice")
                        val categoryModel = Model()
                        categoryModel.productname=name
                        categoryModel.productprice = price

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