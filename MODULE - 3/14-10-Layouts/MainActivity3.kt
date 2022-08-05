package com.example.multimediaex

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

            btn1.setOnClickListener()
            {

            }

    }

    override fun onBackPressed() {


        var alertDialog=AlertDialog.Builder(this)
        alertDialog.setTitle("Select Operation?")
        alertDialog.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

            finishAffinity()

        })
        alertDialog.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int ->

            dialogInterface.cancel()
        })
        alertDialog.show()

    }
}