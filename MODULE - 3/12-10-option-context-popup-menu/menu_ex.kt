package com.example.menuexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity()
{


    lateinit var listView: ListView
    lateinit var list: List<String>
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView=findViewById(R.id.list)

        var data=listOf("A","B","C")
        btn=findViewById(R.id.btn1)


        btn.setOnClickListener()
        {
            val popupmenu:PopupMenu= PopupMenu(applicationContext,btn)
            popupmenu.menuInflater.inflate(R.menu.popup,popupmenu.menu)
            popupmenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.p1 ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()

                }
                true
            })
            popupmenu.show()


    }


       val adapter= ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,data)
       listView.adapter=adapter


        registerForContextMenu(listView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        return when(item.itemId)
        {

            R.id.i1->
            {
                Toast.makeText(applicationContext,"Done",Toast.LENGTH_LONG).show()
                true

            }




            else ->  return super.onOptionsItemSelected(item)
        }


    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.pos -> {
                Toast.makeText(applicationContext, "Done", Toast.LENGTH_LONG).show()
                true

            }


            else -> return super.onContextItemSelected(item)
        }
    }
}