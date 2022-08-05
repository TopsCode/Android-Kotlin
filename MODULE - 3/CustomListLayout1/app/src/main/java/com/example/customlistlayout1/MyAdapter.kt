package com.example.customlistlayout1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var ct:Context,var itemData:List<Models>) :ArrayAdapter<Models>(ct,R.layout.row_data,itemData) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var layoutinflate=LayoutInflater.from(ct);
        var view:View =layoutinflate.inflate(R.layout.row_data,null,true);

        var img=view.findViewById<ImageView>(R.id.img);
        var img_content=view.findViewById<TextView>(R.id.img_content);
        var img_date=view.findViewById<TextView>(R.id.img_date);
        var img_name=view.findViewById<TextView>(R.id.img_name);

        var model:Models=itemData[position];

        img.setImageResource(model.img)
        img_content.text=model.imgContent;
        img_date.text=model.date;
        img_name.text=model.imgName;

        return view
    }
}