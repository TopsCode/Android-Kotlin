package com.example.myapplication3

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog

class ViewActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    var list: List<Model?>? = null
    lateinit var dbHelper: DbHelper
    var arrlist = ArrayList<HashMap<String, String?>>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        listView=findViewById(R.id.list)
        list=ArrayList()
        dbHelper= DbHelper(applicationContext)

        list=dbHelper.viewdata()

        for (user in list!!)
        {
            val hm = HashMap<String, String?>()
            hm["name"] = user!!.modelname
            hm["number"] = user.modelnum
            arrlist.add(hm)
        }

        val from = arrayOf("name", "number")
        val to = intArrayOf(R.id.txtname, R.id.txtnumber)


        val adapter=SimpleAdapter(applicationContext,arrlist,R.layout.design,from,to)
        listView.adapter=adapter

        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        val m1: MenuItem = menu!!.add(0, 1, 0, "update")
        val m2: MenuItem = menu!!.add(0, 2, 0, "delete")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        val acm: AdapterView.AdapterContextMenuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        var id:Int=acm.position
        val user = list!![id]

        if(item.itemId==1)
        {
            val intent=Intent(this,UpdateActivity::class.java)
            intent.putExtra("id", user!!.modelid)
            intent.putExtra("name",user.modelname)
            intent.putExtra("num",user.modelnum)
            startActivity(intent)

        }
        if(item.itemId==2)
        {
           val alertDialog=AlertDialog.Builder(this)
           alertDialog.setTitle("Are you sure you want to delete?")
            alertDialog.setPositiveButton("YES",object:DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int)
                {
                            dbHelper.delete(user!!.modelid)

                    val intent=Intent(this@ViewActivity,ViewActivity::class.java)
                    startActivity(intent)



                }
            })
            alertDialog.setNegativeButton("NO",object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {

                    p0!!.cancel()

                }
            })
            alertDialog.show()


        }

        return super.onContextItemSelected(item)
    }
}