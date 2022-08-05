package com.example.firebasecrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class AdduserActivity : AppCompatActivity()
{
    lateinit var edtname:EditText
    lateinit var edtemail:EditText
    lateinit var edtpass:EditText
    lateinit var b1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adduser)

        edtname=findViewById(R.id.e1)
        edtemail=findViewById(R.id.e2)
        edtpass=findViewById(R.id.e3)
        b1=findViewById(R.id.btn1)

        b1.setOnClickListener()
        {

            var name=edtname.text.toString()
            var email=edtemail.text.toString()
            var pass=edtpass.text.toString()

            val map: HashMap<String,String> = HashMap<String,String>()
            map["name"] = name
            map["email"] = email
            map["pass"] = pass

            FirebaseDatabase.getInstance().getReference()
                .child("vaishali")
                .push()
                .setValue(map)
                .addOnSuccessListener{
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))

            }
                .addOnFailureListener()
                {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }

        }
    }
}