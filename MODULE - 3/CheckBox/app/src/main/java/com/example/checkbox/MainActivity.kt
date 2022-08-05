package com.example.checkbox

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var cb_c=findViewById<CheckBox>(R.id.cb_c)
        var cb_python=findViewById<CheckBox>(R.id.cb_python)
        var cb_java=findViewById<CheckBox>(R.id.cb_java)
        var arr= arrayListOf<String>();
        var fb_send=findViewById<FloatingActionButton>(R.id.fb_send)
        fb_send.setOnClickListener {
            var intent= Intent(this@MainActivity,activity2::class.java)
            startActivity(intent);
        }
        cb_c.setOnCheckedChangeListener{compoundButton, b ->
            if(b)
            {
                arr.add(cb_c.text.toString())
            }
            else{
                arr.remove(cb_c.text.toString())
            }
            Log.d("mydata",arr.toString())
        }
        cb_python.setOnCheckedChangeListener{compoundButton, b ->
            if(b)
            {
                arr.add(cb_python.text.toString())
                cb_python.setBackgroundColor(   Color.CYAN)
            }
            else{
                arr.remove(cb_python.text.toString())
                cb_python.setBackgroundColor(   Color.WHITE)
            }
            Log.d("mydata",arr.toString())
        }
        cb_java.setOnCheckedChangeListener{compoundButton, b ->
            if(b)
            {
                arr.add(cb_java.text.toString())

            }
            else{
                arr.remove(cb_java.text.toString())
            }
            Log.d("mydata",arr.toString())
        }
    }
}