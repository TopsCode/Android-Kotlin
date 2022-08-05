package com.example.jsonkotlinex

import android.content.ContextParams
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.Nullable
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var register: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        username = findViewById(R.id.edt1)
        email = findViewById(R.id.edt2)
        password = findViewById(R.id.edt3)
        register = findViewById(R.id.btnregister)


        register.setOnClickListener()
        {


            val uname = username.text.toString()
            val email = email.text.toString()
            val pass = password.text.toString()

            val stringrequest: StringRequest =
                object : StringRequest(Request.Method.POST, "https://prakrutivyas.000webhostapp.com/regserver/volleyRegister.php", Response.Listener
                {

                    Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show()

                }, Response.ErrorListener {

                    Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show()

                }
                ) {
                    @Nullable
                    @Throws(AuthFailureError::class)
                    override fun getParams(): HashMap<String, String> {
                        val map = HashMap<String, String>()
                        map["username"] = uname
                        map["email"] = email
                        map["password"] = pass

                        return map
                    }
                }
            val queue = Volley.newRequestQueue(this)
            queue.add(stringrequest)

        }
    }
}
