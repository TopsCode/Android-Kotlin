package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UpdateActivity : AppCompatActivity()
{
    lateinit var etuser: EditText
    lateinit var etphone: EditText
    lateinit var btnupdate: Button
    var id=0
    lateinit var dbHelper: DbHelper
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        etuser = findViewById(R.id.updatename)
        etphone = findViewById(R.id.updatepass)
        btnupdate = findViewById(R.id.btnupdate)
        dbHelper= DbHelper(applicationContext)

        val bundle: Bundle = getIntent().getExtras()!!
        id = bundle.getInt("id")
        etuser?.setText(bundle.getString("name"))
        etphone?.setText(bundle.getString("num"))

        btnupdate.setOnClickListener()
        {
            var name=etuser.text.toString()
            var num=etphone.text.toString()


            var m=Model()
            m.modelid=id
            m.modelname=name
            m.modelnum=num

            var data= dbHelper.update(m)

            val intent=Intent(this,ViewActivity::class.java)
            startActivity(intent)
        }
    }
}