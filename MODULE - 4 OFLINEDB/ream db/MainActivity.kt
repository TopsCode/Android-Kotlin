package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent




class MainActivity : AppCompatActivity()
{
    var realm: Realm? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        realm=Realm.getInstance(Realm.getDefaultConfiguration())


        btn1.setOnClickListener()
        {

            var name=edt1.text.toString()
            var pass=edt2.text.toString()

            realm!!.beginTransaction()


            val m: Model = realm!!.createObject(Model::class.java)
            m.name=name
            m.pass=pass

            realm!!.commitTransaction()

            Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_LONG).show()


        }
        btn2.setOnClickListener()
        {

                startActivity(Intent(this@MainActivity, show::class.java))
        }

    }
}