package com.example.tts

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.widget.Button
import android.widget.ImageView

class CamerActivity : AppCompatActivity() {

    lateinit var btn:Button
    lateinit var img:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camer)


        btn=findViewById(R.id.btn)
        img=findViewById(R.id.img)

        btn.setOnClickListener()
        {

            val i =Intent(ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,1)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if(requestCode==1)
        {
           val bitmap:Bitmap= data!!.extras!!.get("data") as Bitmap
            img.setImageBitmap(bitmap)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}