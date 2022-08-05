package com.example.example2

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.CAMERA
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity()
{
    lateinit var rate:RatingBar
    lateinit var btn:Button
    lateinit var btn2:Button



    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rate=findViewById(R.id.rating)
        btn=findViewById(R.id.web)
        btn2=findViewById(R.id.call)



        if(checkSelfPermission(CALL_PHONE)!==PERMISSION_GRANTED)
        {


            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(CALL_PHONE),1)
        }


        rate.setOnRatingBarChangeListener()
        {
                ratingBar: RatingBar, fl: Float, b: Boolean ->

                var data= ratingBar.rating.toString()

                Toast.makeText(applicationContext,data,Toast.LENGTH_LONG).show()


        }
        btn.setOnClickListener()
        {
                    val intent=Intent(this,SecondActivity::class.java)
                    startActivity(intent)
        }

        btn2.setOnClickListener()
        {
            var num="9724004242"
            val intent=Intent(Intent.ACTION_CALL)
            intent.setData(Uri.parse("tel:"+num))
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {

        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        return when(item.itemId)
        {

            R.id.i1 ->
            {
                Toast.makeText(applicationContext, "you are succesfully Loggedout", Toast.LENGTH_LONG).show()
                finishAffinity()
                true
            }


            else -> super.onOptionsItemSelected(item)
        }
    }
}