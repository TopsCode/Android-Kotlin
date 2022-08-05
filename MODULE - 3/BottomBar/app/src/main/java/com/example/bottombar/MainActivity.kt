package com.example.bottombar

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bnv=findViewById<BottomNavigationView>(R.id.bnv)

        loadFragment(HomeFragment())
        bnv.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.op_home->{
                    loadFragment(HomeFragment())

                }
                R.id.op_profile->{
                    loadFragment(ProfileFragment())
                }
                R.id.op_settings->{
                    loadFragment(SettingFragment())
                }

            }
            return@setOnNavigationItemSelectedListener true
        }


    }
    fun loadFragment(frag:Fragment){

        var fragTranscation=supportFragmentManager.beginTransaction()
        fragTranscation.replace(R.id.mainContainer,frag)
        fragTranscation.addToBackStack(null)//Disable back button activity
        fragTranscation.commit()
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