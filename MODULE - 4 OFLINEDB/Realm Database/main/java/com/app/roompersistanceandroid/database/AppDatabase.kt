package com.app.roompersistanceandroid.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.roompersistanceandroid.database.dao.UserDAO
import com.app.roompersistanceandroid.database.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun userDao() : UserDAO

}