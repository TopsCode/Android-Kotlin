package com.example.navigationdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_next=findViewById<Button>(R.id.btn_next);

        btn_next.setOnClickListener{
            //To navigate to different activity
//            var intent= Intent(this@MainActivity,SecondActivity::class.java)
//            startActivity(intent);
//            finish();

            //to go to website
            var intent=Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://monkeytype.com/"))
            startActivity(intent);

        }
    }
}