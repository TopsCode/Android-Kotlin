package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginpage)
        var flag : Boolean=true;
        var tv_login = findViewById<TextView>(R.id.tv_login)
        var btn_submit=findViewById<Button>(R.id.btn_submit)
        var et_email =findViewById<EditText>(R.id.et_email)
        var et_pwd =findViewById<EditText>(R.id.et_pwd)
        var radio_status:Int? = null


        //Text view click event
        tv_login.setOnClickListener {
//            Toast.makeText(this,"Login page",Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Value = " + tv_login.text.toString(), Toast.LENGTH_SHORT).show()

        }

        //Button click event
        btn_submit.setOnClickListener{
//            Toast.makeText(this,"Email = "+et_email.text.toString(),Toast.LENGTH_SHORT).show()
//            Toast.makeText(this,"Pwd = "+et_pwd.text.toString(),Toast.LENGTH_SHORT).show()
//            Log.d("mydata","Email = "+et_email.text.toString()+" , password = "+et_pwd.text.toString());
//            if (flag)
//            {
//                tv_login.text="Logout"
//            }
//            else
//            {
//                tv_login.text="LogIn"
//            }
//            flag=!flag;
            if (radio_status == R.id.rb_android) {
                Toast.makeText(this, "android", Toast.LENGTH_SHORT).show()
            }

        }

            var rb_main=findViewById<RadioGroup>(R.id.rg_main);
        rb_main.setOnCheckedChangeListener{ RadioGroup, i->


                radio_status=i;
        }

        }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("mydata","Destroyed")
        }

    override fun onRestart() {
        super.onRestart()
        Log.d("mydata","onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("mydata","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("mydata","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("mydata","onStop")
    }
    }
