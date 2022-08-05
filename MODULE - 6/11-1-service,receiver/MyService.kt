package com.example.serviceex

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder
    {
        TODO("Return the communication channel to the service.")
    }

    override fun onStart(intent: Intent?, startId: Int)
    {
        super.onStart(intent, startId)
        Toast.makeText(applicationContext,"started",Toast.LENGTH_LONG).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
        return super.onStartCommand(intent, flags, startId)
        Toast.makeText(applicationContext,"On Start",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy()
    {
        super.onDestroy()
        Toast.makeText(applicationContext,"stopped",Toast.LENGTH_LONG).show()
    }
}