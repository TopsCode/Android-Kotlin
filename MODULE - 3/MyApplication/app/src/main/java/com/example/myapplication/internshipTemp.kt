package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class internshipTemp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internship_temp)

        var btn=findViewById<Button>(R.id.btn_btn)
        var editText=findViewById<EditText>(R.id.ed_text)

        btn.setOnClickListener {

            var data:String= editText.text.toString()
            Toast.makeText(this, "Demo Toast = "+data, Toast.LENGTH_SHORT).show()
        }
    }
}