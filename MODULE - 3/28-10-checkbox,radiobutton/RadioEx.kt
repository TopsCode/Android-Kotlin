package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_radio_ex.*

class RadioEx : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_ex)

        rb1.setOnCheckedChangeListener(this)
        rb2.setOnCheckedChangeListener(this)

    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean)
    {
        if(rb1.isChecked)
        {
            Toast.makeText(this,"Male",Toast.LENGTH_LONG).show()
        }
        if(rb2.isChecked)
        {
            Toast.makeText(this,"femqale",Toast.LENGTH_LONG).show()
        }
    }
}