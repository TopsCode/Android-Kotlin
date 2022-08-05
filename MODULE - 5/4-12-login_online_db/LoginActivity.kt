package com.example.jsonkotlinex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.Nullable
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class LoginActivity : AppCompatActivity()
{

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.edt2)
        password = findViewById(R.id.edt3)
        login = findViewById(R.id.btnlogin)

        login.setOnClickListener()
        {
            val email = email.text.toString()
            val pass = password.text.toString()

            val stringRequest = StringRequest(
                Request.Method.POST,
                "https://prakrutivyas.000webhostapp.com/regserver/login.php?email=" + email + "&pass=" + pass,
                { response ->
                    if (response.trim { it <= ' ' } == "0")
                    {
                        Toast.makeText(this@LoginActivity, "fail", Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        Toast.makeText(this@LoginActivity, "success", Toast.LENGTH_SHORT).show()
                    }
                }) { Toast.makeText(this@LoginActivity, "No Internet", Toast.LENGTH_SHORT).show() }

            val queue = Volley.newRequestQueue(this@LoginActivity)
            queue.add(stringRequest)
        }
    }
}