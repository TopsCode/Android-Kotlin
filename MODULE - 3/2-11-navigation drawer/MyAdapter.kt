package com.example.myapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import org.w3c.dom.Text

class MyAdapter(var context: Context,var list: MutableList<Model>) :BaseAdapter()
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

            var view=LayoutInflater.from(context)
            var xyz=view.inflate(R.layout.design,p2,false)

        var txt2: TextView
        var txt:TextView

        txt=xyz.findViewById(R.id.txt1)
        txt2=xyz.findViewById(R.id.txt2)

         txt.setText(list.get(p0).title)
         txt2.setText(list.get(p0).subtitle)



       return xyz
    }
}