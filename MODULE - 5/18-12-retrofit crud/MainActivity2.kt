package com.example.retrofitcrudex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcrud.MyAdapter
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity()
{

    lateinit var listView: RecyclerView
    var list: List<Model>? = null
    var api: Apiinterface? = null


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        listView = findViewById(R.id.list)
        list = ArrayList()

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        listView.setLayoutManager(layoutManager)
        api = ApiClient().getApiClient()!!.create<Apiinterface>(Apiinterface::class.java)

        val call = api!!.viewdata
        call!!.enqueue(object : Call<List<Model?>>, Callback<List<Model?>?> {
          /*  override fun onResponse(call: Call<List<Model?>>, response: Response<List<Model?>>) {

            }

            override fun onFailure(call: Call<List<Model?>>, t: Throwable) {}*/
            override fun onResponse(call: Call<List<Model?>?>, response: Response<List<Model?>?>) {
              list = response.body() as MutableList<Model>?
              val customAdapter = MyAdapter(applicationContext, list!!)
              listView.adapter = customAdapter
            }

            override fun onFailure(call: Call<List<Model?>?>, t: Throwable) {
               Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
            }

            override fun clone(): Call<List<Model?>> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<List<Model?>> {
                TODO("Not yet implemented")
            }

            override fun enqueue(callback: Callback<List<Model?>>) {
                TODO("Not yet implemented")
            }

            override fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }
        })


    }
}



