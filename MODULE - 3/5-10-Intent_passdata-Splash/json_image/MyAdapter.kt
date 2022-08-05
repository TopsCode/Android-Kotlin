package com.example.firstapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context,val list: MutableList<Model>) :BaseAdapter()
{
    override fun getCount(): Int
    {
      return list.size
    }

    override fun getItem(p0: Int): Any
    {
       return p0
    }

    override fun getItemId(p0: Int): Long
    {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {

        var myview=p1
        val `in`: LayoutInflater = LayoutInflater.from(context)
        myview=`in`.inflate(R.layout.design,p2,false)

        val textView:TextView=myview.findViewById(R.id.txt)
        val imageView:ImageView=myview.findViewById(R.id.img)

        //val m =list.get(p0)

        textView.setText(list.get(p0).name)
        //imageView.setImageResource(list.get(p0).image)
        Picasso.get()
            .load(list.get(p0).image)
            .into(imageView)

        return myview
    }

}