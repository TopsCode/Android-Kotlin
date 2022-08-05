package com.example.jsonexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myapp2.R

class MyAdapter(val context:Context,val list: MutableList<Model>) :BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(p0: Int): Any
    {
        return  p0
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

        val txt1:TextView=myview.findViewById(R.id.txt1)
        val txt2:TextView=myview.findViewById(R.id.txt2)
        val txt3:TextView=myview.findViewById(R.id.txt3)
        val txt4:TextView=myview.findViewById(R.id.txt4)

        val model: Model = list!![p0]
        txt1.setText(model.productname)
        txt2.setText(model.productprice)
        txt3.setText(model.productquantity)
        txt4.setText(model.productdescription)


        return myview
    }
}