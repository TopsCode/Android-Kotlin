package com.example.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class PopUpMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_menu)
        var btn_pm=findViewById<Button>(R.id.btn_pm);
        var pupmenu= PopupMenu(applicationContext,btn_pm);
        pupmenu.menuInflater.inflate(R.menu.mymenu,pupmenu.menu)
        btn_pm.setOnClickListener {
            pupmenu.show();
        }
        pupmenu.setOnMenuItemClickListener {
            if(it.itemId == R.id.op_setting){
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
            }
            true
            if(it.itemId == R.id.op_chat){
                var intent= Intent(this@PopUpMenu,chat::class.java)
                startActivity(intent);
            }
            true
        }

    }


}