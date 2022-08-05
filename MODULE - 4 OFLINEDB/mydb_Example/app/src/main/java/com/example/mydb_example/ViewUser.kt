package com.example.mydb_example

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_user)

        var rev_data=findViewById<RecyclerView>(R.id.rev_data)
        rev_data.layoutManager=LinearLayoutManager(this)

        var db_helper=DatabaseHelper(this)
        var userList:MutableList<UserModel> = ArrayList()
        userList=db_helper.getAllData()

        var myadapter=Myadapter(this,userList)
        rev_data.adapter=myadapter
    }
}