package com.example.recyclerviewplaystore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rev=findViewById<RecyclerView>(R.id.rev);

        rev.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
//        rev.layoutManager=LinearLayoutManager(this,1)

        var al=ArrayList<Models>()

        al.add(Models("Pubg:BatteleGround",R.mipmap.pubg,R.mipmap.pubg_main,"4.4","864MB","Action","Shooter"))
        al.add(Models("Pubg:BatteleGround",R.mipmap.pubg,R.mipmap.pubg_main,"4.4","864MB","Action","Shooter"))
        al.add(Models("Pubg:BatteleGround",R.mipmap.pubg,R.mipmap.pubg_main,"4.4","864MB","Action","Shooter"))

        var adapter=Myadapter(al)
        rev.adapter=adapter
    }
}