package com.app.roompersistanceandroid.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user-table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id:Int =0,
    var name:String,
    var email:String,
    @ColumnInfo(name = "mobile")
    var contact:String?
)
