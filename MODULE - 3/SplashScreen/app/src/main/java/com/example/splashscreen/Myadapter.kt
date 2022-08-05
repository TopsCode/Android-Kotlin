package com.example.splashscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Myadapter(var myArrayList:List<Models>):RecyclerView.Adapter<Myadapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter.ViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.row_data,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Myadapter.ViewHolder, position: Int) {
        var myModel= myArrayList[position]

        holder.img.setImageResource(myModel.img)
        holder.title.setText(myModel.title)
    }

    override fun getItemCount(): Int {
        return myArrayList.size
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        var img=itemView.findViewById<ImageView>(R.id.im_view)
        var title=itemView.findViewById<TextView>(R.id.tv_view)
    }
}