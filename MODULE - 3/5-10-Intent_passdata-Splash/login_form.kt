package com.example.formexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var edtname:EditText
    lateinit var edtpass:EditText
    lateinit var btnlogin:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtname=findViewById(R.id.edtname)
        edtpass=findViewById(R.id.edtpass)
        btnlogin=findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener()
        {

            var name=edtname.text.toString()
            var pass=edtpass.text.toString()

         /*   if(name.length==0 && pass.length==0)
            {
                edtname.setError("please enter name")
                edtpass.setError("please enter password")
            }
            else if(name.length==0)
            {
                edtname.setError("please enter name")
            }
            else if(pass.length==0)
            {
                edtpass.setError("please enter password")
            }*/

            if(name.equals("tops") && pass.equals("1234"))
            {
                Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()

                val intent=Intent(applicationContext,MainActivity2::class.java)
                intent.putExtra("t1",name)
                startActivity(intent)
            }

            else
            {
                Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()

            }




        }

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}