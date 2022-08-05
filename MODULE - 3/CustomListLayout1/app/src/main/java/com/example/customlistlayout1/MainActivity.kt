package com.example.customlistlayout1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lv_item=findViewById<ListView>(R.id.lv_item)

        var itemData= mutableListOf<Models>();
        var room1Content:String="whether your industry,if you're full time professional,your smartphone"

        itemData.add((Models("Image 1",R.mipmap.room1,room1Content,"22/12/2022")))
        itemData.add((Models("Image 2",R.mipmap.room2,room1Content,"22/12/2022")))
        itemData.add((Models("Image 3",R.mipmap.room3,room1Content,"22/12/2022")))
        itemData.add((Models("Image 4",R.mipmap.room4,room1Content,"22/12/2022")))

        var myadapter=MyAdapter(this,itemData)
        lv_item.adapter=myadapter;

    }
}