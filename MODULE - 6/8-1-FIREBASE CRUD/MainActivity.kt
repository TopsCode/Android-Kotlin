package com.example.firebasecrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity()
{
    lateinit var myadapter1:myadapter
    lateinit var recyclerView: RecyclerView
    lateinit var floatingActionButton: FloatingActionButton
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.reycler)
        floatingActionButton=findViewById(R.id.f1)
        list=ArrayList()

        val layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(applicationContext)
        recyclerView.layoutManager=layoutManager

        val options = FirebaseRecyclerOptions.Builder<Model>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("vaishali"), Model::class.java)
            .build()

        myadapter1=myadapter(options)
        recyclerView.setAdapter(myadapter1)
        myadapter1!!.notifyDataSetChanged()


        floatingActionButton.setOnClickListener()
        {
            startActivity(Intent(this, AdduserActivity::class.java))

        }

    }
    override fun onStart() {
        super.onStart()
        myadapter1!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        myadapter1!!.stopListening()
    }

    override fun onRestart() {
        super.onRestart()
        myadapter1!!.startListening()
    }

    override fun onResume() {
        super.onResume()
        myadapter1!!.startListening()
    }

    override fun onPause() {
        super.onPause()
        myadapter1!!.stopListening()
    }
}