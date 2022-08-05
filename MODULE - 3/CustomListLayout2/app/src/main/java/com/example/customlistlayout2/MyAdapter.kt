package com.example.customlistlayout2

import android.content.Context
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var ct:Context,var itemData:List<Models>):ArrayAdapter<Models>(ct,R.layout.row_data,itemData) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var layoutinflater=LayoutInflater.from(ct);

        var view:View=layoutinflater.inflate(R.layout.row_data,null,true)

        var img=view.findViewById<ImageView>(R.id.img);
        var itemOff=view.findViewById<TextView>(R.id.item_off)
        var itemName=view.findViewById<TextView>(R.id.item_name)
        var itemCategory=view.findViewById<TextView>(R.id.item_category)
        var itemCostDetails=view.findViewById<TextView>(R.id.item_costDetails)
        var itemMinDetails=view.findViewById<TextView>(R.id.item_minDetails)
        var itemDiscountDetails=view.findViewById<TextView>(R.id.item_discountDetails)
        var itemRating=view.findViewById<TextView>(R.id.item_rating)

        var model:Models=itemData[position]

        img.setImageResource(model.img);
        itemOff.text=model.itemOff
        itemName.text=model.itemName
        itemCategory.text=model.itemCategory
        itemCostDetails.text=model.itemCostDetails
        itemMinDetails.text=model.itemMinDetails
        itemDiscountDetails.text=model.itemDiscountDetails
        itemRating.text=model.itemRating
//        itemRating.backgroundTintMode = ct.resources()
//        itemRating.textColors=ct.getColor(R.color.black)

        return view;
    }
}