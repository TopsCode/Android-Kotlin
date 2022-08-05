package com.example.listview

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lv=findViewById<ListView>(R.id.lv)
        //Static list view
//        lv.setOnItemClickListener { parent, view, i, id ->
//            Toast.makeText(this@MainActivity,""+lv.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
//        }
        //Static list with array
//        var subjects= arrayOf("java","c","python","C++")
//        var adapter:ArrayAdapter<*>
//        adapter=ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,subjects)
//        lv.adapter=adapter


        //dynamic Adapter
//        var et_activityAdder=findViewById<EditText>(R.id.et_activityAdder)
//        var btn_addActivity=findViewById<Button>(R.id.bt_addActivity)
//        var adapter:ArrayAdapter<*>
//
//        var data = arrayListOf<String>()
//        btn_addActivity.setOnClickListener {
//            data.add(et_activityAdder.text.toString())
//            et_activityAdder.text.clear()
//            adapter=ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,data)
//            lv.adapter=adapter
//        }

        //Spinner
        var sp=findViewById<Spinner>(R.id.spinner1)
        sp.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,""+lv.getItemAtPosition(position),Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        var btn_alert=findViewById<Button>(R.id.btn_alert)
        btn_alert.setOnClickListener {
        var builder=AlertDialog.Builder(this).setTitle("Alert").setMessage("Are you sure u want to exit")
            .setPositiveButton("Yes",DialogInterface.OnClickListener{
                dialogInterface,i->
                Toast.makeText(this, "Yess", Toast.LENGTH_SHORT).show()
                dialogInterface.dismiss()
            })
            .setNegativeButton("NO",DialogInterface.OnClickListener{
                dialogInterface,i->
                Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
                dialogInterface.dismiss()
            })
            .setNeutralButton("cancel",DialogInterface.OnClickListener{ dialogInterface,i->
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                dialogInterface.cancel()
            })
            .setCancelable(false)
            builder.show()

        }

    }
}