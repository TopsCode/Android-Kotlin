package com.example.recyclerviewplaystore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Myadapter(var myArrayList:List<Models>):RecyclerView.Adapter<Myadapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter.ViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.row_data,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Myadapter.ViewHolder, position: Int) {
        var myModel= myArrayList[position]

        holder.img.setImageResource(myModel.img)
        holder.promImg.setImageResource(myModel.promImage)
        holder.title.setText(myModel.title)
        holder.rating.setText(myModel.rating)
        holder.category.setText(myModel.cat)
        holder.subcategory.setText(myModel.subCat)
        holder.appsize.setText(myModel.size)
    }

    override fun getItemCount(): Int {
        return myArrayList.size
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var promImg=itemView.findViewById<ImageView>(R.id.promImg)
        var img=itemView.findViewById<ImageView>(R.id.main_img)
        var title=itemView.findViewById<TextView>(R.id.title)
        var rating=itemView.findViewById<TextView>(R.id.rating)
        var appsize=itemView.findViewById<TextView>(R.id.size)
        var category=itemView.findViewById<TextView>(R.id.category)
        var subcategory=itemView.findViewById<TextView>(R.id.subcategory)




    }


}