package com.example.mydb_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_register=findViewById<Button>(R.id.btn_register)
        var username=findViewById<EditText>(R.id.ed_username)
        var email=findViewById<EditText>(R.id.ed_email)
        var password=findViewById<EditText>(R.id.ed_password)
        var contact=findViewById<EditText>(R.id.ed_contact)

        var id:Int;
        btn_register.setOnClickListener {
//            Toast.makeText(this, username.text.toString()+","+email.text.toString()+","+password.text.toString()+","+contact.text.toString(), Toast.LENGTH_SHORT).show()

            var dbhelper=DatabaseHelper(this)
            var x=dbhelper.insert(UserModel(it.id!!,username.text.toString(),email.text.toString(),password.text.toString(),contact.text.toString()))
            var intent=Intent(MainActivity@this,ViewUser::class.java)
            startActivity(intent)
        }

        var btn_db=findViewById<MaterialButton>(R.id.btn_db)
        btn_db.setOnClickListener{
            var intent=Intent(MainActivity@this,ViewUser::class.java)
            startActivity(intent)
        }

        var btn_haveAccount=findViewById<MaterialButton>(R.id.btn_haveAccount)
        btn_haveAccount.setOnClickListener{
            var intent=Intent(MainActivity@this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

}