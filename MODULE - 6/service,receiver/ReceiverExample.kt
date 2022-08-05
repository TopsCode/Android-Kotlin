package com.example.serviceex

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ReceiverExample : AppCompatActivity()
{

    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver_example)

        btn=findViewById(R.id.btn)

        btn.setOnClickListener()
        {
            val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
                applicationContext.registerReceiver(null, ifilter)
            }

            // isCharging if true indicates charging is ongoing and vice-versa
            val status: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
            val isCharging: Boolean = status == BatteryManager.BATTERY_STATUS_CHARGING
                    || status == BatteryManager.BATTERY_STATUS_FULL

            // Display whatever the state in the form of a Toast
            if(isCharging) {
                Toast.makeText(applicationContext, "Charging", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext,"Not Charging", Toast.LENGTH_LONG).show()
            }

        }

    }
}