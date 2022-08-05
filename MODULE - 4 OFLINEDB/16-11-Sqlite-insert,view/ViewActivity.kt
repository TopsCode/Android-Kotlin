package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class ViewActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    var list: List<Model?>? = null
    lateinit var dbHelper: DbHelper
    var arrlist = ArrayList<HashMap<String, String?>>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        listView=findViewById(R.id.list)
        list=ArrayList()
        dbHelper= DbHelper(applicationContext)

        list=dbHelper.viewdata()

        for (user in list!!)
        {
            val hm = HashMap<String, String?>()
            hm["name"] = user!!.modelname
            hm["number"] = user.modelnum
            arrlist.add(hm)
        }

        val from = arrayOf("name", "number")
        val to = intArrayOf(R.id.txtname, R.id.txtnumber)


        val adapter=SimpleAdapter(applicationContext,arrlist,R.layout.design,from,to)
        listView.adapter=adapter




    }
}