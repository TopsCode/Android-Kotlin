package com.example.customlistview

import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelStore

class MyAdapter(var ct:Context,var itemData:List<models> ) :ArrayAdapter<models>(ct,R.layout.row_data,itemData) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var layoutInflater:LayoutInflater = LayoutInflater.from(ct);
        val view:View = layoutInflater.inflate(R.layout.row_data,null,true)

        var imview=view.findViewById<ImageView>(R.id.imview)
        var tv_data=view.findViewById<TextView>(R.id.tv_data)

        var models:models = itemData[position]

        imview.setImageResource(models.img)
        tv_data.text=models.title;
        return view
    }
}