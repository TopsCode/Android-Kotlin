package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lvdata=findViewById<ListView>(R.id.lvdata)

        var modelList= mutableListOf<models>()

        modelList.add(models("Android 11" ,R.mipmap.oneone))
        modelList.add(models("Oreo" ,R.mipmap.oreo))
        modelList.add(models("Android studio" ,R.mipmap.studio))
        var myadapter = MyAdapter(this,modelList)
        lvdata.adapter=myadapter;
    }
}