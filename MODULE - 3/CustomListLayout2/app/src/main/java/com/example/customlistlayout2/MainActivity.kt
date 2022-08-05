package com.example.customlistlayout2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lvdata=findViewById<ListView>(R.id.lvdata)
        var itemData= mutableListOf<Models>()
        itemData.add(Models(R.mipmap.food1,"20% OFF","Samosa World","Fast Food","Cost $100 for one","Min $100.Avg 45 min.Pay Online/Cash","20% off -auto applies during checkout","5.0"))
        itemData.add(Models(R.mipmap.food2,"20% OFF","Biryani","Fast Food","Cost $100 for one","Min $100.Avg 45 min.Pay Online/Cash","20% off -auto applies during checkout","5.0"))
        itemData.add(Models(R.mipmap.food3,"20% OFF","Pasta","Fast Food","Cost $100 for one","Min $100.Avg 45 min.Pay Online/Cash","20% off -auto applies during checkout","5.0"))
        itemData.add(Models(R.mipmap.food4,"20% OFF","Burger","Fast Food","Cost $100 for one","Min $100.Avg 45 min.Pay Online/Cash","20% off -auto applies during checkout","5.0"))
        var myAdapter=MyAdapter(this, itemData)
        lvdata.adapter=myAdapter
    }
}