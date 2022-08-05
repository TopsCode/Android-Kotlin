package com.example.menu

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

@SuppressLint("WrongViewCast")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_begin=findViewById<Button>(R.id.btn_begin);
        //Uncomment for custom dialog
//        btn_begin.setOnClickListener {
//            var custom_dialog=Dialog(this@MainActivity);
//            custom_dialog.setContentView(R.layout.custom_layout);
//            custom_dialog.setCancelable(false);
//            custom_dialog.show();
//
//            var cl_btn_send=custom_dialog.findViewById<Button>(R.id.btn_send)
//            var cl_tv_display=custom_dialog.findViewById<EditText>(R.id.et_display);
//
//            cl_btn_send.setOnClickListener {
//                Toast.makeText(this,"Pressed",Toast.LENGTH_SHORT).show();
//                custom_dialog.dismiss();
//            }
//        }

        //List dialog
//        btn_begin.setOnClickListener {
//            var mydialog=AlertDialog.Builder(this@MainActivity);
//
//            var subject= arrayOf("Java","python");
//
//            mydialog.setItems(subject,DialogInterface.OnClickListener{ dialog: DialogInterface?, i: Int ->
//                when(i)
//                {
//                    0 -> Toast.makeText(this, "Java", Toast.LENGTH_SHORT).show()
//                    1 -> Toast.makeText(this, "python", Toast.LENGTH_SHORT).show()
//                }
//            })
//            var dialog=mydialog.create();
//            dialog.show();
//        }

        //Radio dialog
//            btn_begin.setOnClickListener {
//            var mydialog=AlertDialog.Builder(this@MainActivity);
//            mydialog.setTitle("Select any one");
//            var subject= arrayOf("Java","python");
//
//            mydialog.setSingleChoiceItems(subject,1, DialogInterface.OnClickListener { dialog, i ->
//                Toast.makeText(this, ""+subject[i], Toast.LENGTH_SHORT).show()
//            })
//                mydialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, i ->
//                    dialog.dismiss();
//                })
//            var dialog=mydialog.create();
//            dialog.show();
//        }


        //Check box
        btn_begin.setOnClickListener {

            var mydialog=AlertDialog.Builder(this@MainActivity);
            mydialog.setTitle("Select any one");
            var subject= arrayOf("Java","python","C","C++");
            var selectedItemArray= arrayListOf<String>()


            mydialog.setMultiChoiceItems(subject,null, DialogInterface.OnMultiChoiceClickListener { dialog, i, isChecked ->
                if(isChecked)
                {
                    selectedItemArray.add(subject[i]);
                }
                else
                {
                    selectedItemArray.remove(subject[i]);
                }
            })
            mydialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, i ->
                Toast.makeText(this, ""+selectedItemArray.toString(), Toast.LENGTH_SHORT).show()
                dialog.dismiss();
            })
            var dialog=mydialog.create();
            dialog.show();
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.op_chat)
        {
//            Toast.makeText(this, "Chat", Toast.LENGTH_SHORT).show()
            var intent= Intent(this@MainActivity,chat::class.java)
            startActivity(intent);
        }
        else if(item.itemId == R.id.op_popupmenu)
        {
//            Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show()
            var intent= Intent(this@MainActivity,PopUpMenu::class.java)
            startActivity(intent);
        }
        else if(item.itemId == R.id.op_setting)
        {
            Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
//        super.onBackPressed() //this is used to go one step back in activity menu.but if it is in last menu then it will exit the app.
        var builder= AlertDialog.Builder(this).setTitle("Alert").setMessage("Are you sure u want to exit")
            .setPositiveButton("Yes", DialogInterface.OnClickListener{
                    dialogInterface,i->
               finish();

            })
            .setNegativeButton("NO", DialogInterface.OnClickListener{
                    dialogInterface,i->
                Toast.makeText(this, "App will not be closed", Toast.LENGTH_SHORT).show()
                dialogInterface.dismiss()
            })
            .setNeutralButton("cancel", DialogInterface.OnClickListener{ dialogInterface, i->
                Toast.makeText(this, "Process terminated", Toast.LENGTH_SHORT).show()
                dialogInterface.cancel()
            })
            .setCancelable(false)
        builder.show()

    }



}