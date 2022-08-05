package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ordering_system.*
import java.lang.StringBuilder

class OrderingSystem : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordering_system)


        btnorder.setOnClickListener()
        {
            var amount:Float=0.0F
            val builder:StringBuilder= StringBuilder()
             builder.append("\n selected Items: \n")

            if(chk1.isChecked)
            {
                        builder.append("\n Pizza @rs.100 \n")
                        amount+=100


            }
            if(chk2.isChecked)
            {
                builder.append("\n Burger @rs.70 \n")
                amount+=70

            }
            if(chk3.isChecked)
            {
                builder.append("\n Coffee @rs.120 \n")
                amount+=120

            }
            builder.append("\n Total: "+amount)

            Toast.makeText(this,builder.toString(),Toast.LENGTH_LONG).show()

            val intent=Intent(this,BillActivity::class.java)
            intent.putExtra("bill",builder.toString())
            startActivity(intent)

        }

    }
}