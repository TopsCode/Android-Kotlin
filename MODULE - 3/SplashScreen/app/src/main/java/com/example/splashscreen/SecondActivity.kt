package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var rev=findViewById<RecyclerView>(R.id.rev);

        rev.layoutManager=GridLayoutManager(this,2)
//        rev.layoutManager=LinearLayoutManager(this,1)

        var al=ArrayList<Models>()

        al.add(Models(R.mipmap.food1,"Burger"))
        al.add(Models(R.mipmap.food1,"Burger"))

        var adapter=Myadapter(al)
        rev.adapter=adapter

    }
}