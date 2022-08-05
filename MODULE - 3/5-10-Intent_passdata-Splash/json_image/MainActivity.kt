package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView=findViewById(R.id.list)
        list=ArrayList()


        val stringRequest=StringRequest(Request.Method.POST,"https://www.simplifiedcoding.net/demos/view-flipper/heroes.php",object:Response.Listener<String?>,
            Response.ErrorListener {
            override fun onResponse(response: String?)
            {

                   val jsonObject=JSONObject(response)
                   val jsonArray=jsonObject.getJSONArray("heroes")
                    for (i in 0 until jsonArray.length())
                    {
                        val jsonobject2=jsonArray.getJSONObject(i);
                        val name=jsonobject2.getString("name")
                        val image=jsonobject2.getString("imageurl")
                         var m=Model()
                         m.name=name
                         m.image=image
                         list.add(m)

                    }
                val  myAdapter=MyAdapter(applicationContext,list)
                listView.adapter=myAdapter


            }

            override fun onErrorResponse(error: VolleyError?)
            {
                Toast.makeText(applicationContext,"No Ineternet",Toast.LENGTH_LONG).show()
            }
        },object :Response.ErrorListener
        {
            override fun onErrorResponse(error: VolleyError?)
            {
               Toast.makeText(applicationContext,"No Ineternet",Toast.LENGTH_LONG).show()
            }
        })
        val requestQueue=Volley.newRequestQueue(applicationContext)
        requestQueue.add(stringRequest)

    }
}