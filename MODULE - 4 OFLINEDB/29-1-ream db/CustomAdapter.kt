package com.example.myapplication


import android.content.Context
import android.widget.BaseAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View

import android.widget.TextView

class CustomAdapter(var context: Context?, list: MutableList<Model?>) : BaseAdapter()
{

    var list: List<Model?>

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(i: Int): Any {
        return list[i]!!
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        val layoutInflater = LayoutInflater.from(context)
        view = layoutInflater.inflate(R.layout.desing, viewGroup, false)
        val textView = view.findViewById<TextView>(R.id.t1)
        val textView2 = view.findViewById<TextView>(R.id.t2)
        textView.setText(list[i]!!.name)
        textView2.setText(list[i]!!.pass)
        return view
    }

    init {
        this.list = list
    }
}