package com.example.listexample

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    lateinit var list1: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list1= listOf("Android","java","php","Android","java","php","Android","java","php","Android","java","php","Android","java","php")

        val arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,list1)
        list.adapter=arrayAdapter

        btn1.setOnClickListener()
        {

                val layout=layoutInflater.inflate(R.layout.custom_toast,null)

                val toast=Toast(this)
                toast.view=layout
                toast.setGravity(Gravity.CENTER,0,0)
                toast.duration=Toast.LENGTH_LONG
                toast.show()

        }

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(s: String?): Boolean
            {
              /*  if(list1.contains(s))
                {
                    arrayAdapter.filter.filter(data)
                }*/
              return false
            }

            override fun onQueryTextChange(s: String?): Boolean
            {
                var data:String= s!!

                arrayAdapter.filter.filter(data)


               return false
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {


        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed()
    {
        val alertDialog=AlertDialog.Builder(this)
        alertDialog.setTitle("Are you sure you want to exit")
        alertDialog.setPositiveButton("YES",{
                dialogInterface: DialogInterface, i: Int ->

                finishAffinity()

        })
        alertDialog.setNegativeButton("No",{
                dialogInterface: DialogInterface, i: Int ->
            dialogInterface.cancel()
        })
        /*alertDialog.setNeutralButton()*/
        alertDialog.show()

    }
}