package com.app.roompersistanceandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.app.roompersistanceandroid.database.AppDatabase
import com.app.roompersistanceandroid.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var db: AppDatabase
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            this, AppDatabase::class.java, "tops-student"
        ).allowMainThreadQueries().build()


    }
}