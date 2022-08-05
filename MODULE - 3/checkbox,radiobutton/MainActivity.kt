package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   /*     chk1.setOnCheckedChangeListener()
        {
                compoundButton: CompoundButton, b: Boolean ->



        }*/
        chk1.setOnCheckedChangeListener(this)

    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean)
    {
            if(chk1.isChecked)
            {
                Toast.makeText(this,"checked",Toast.LENGTH_LONG).show()
            }
            if(!chk1.isChecked)
            {
                Toast.makeText(this,"Not Checked",Toast.LENGTH_LONG).show()
            }

    }
}