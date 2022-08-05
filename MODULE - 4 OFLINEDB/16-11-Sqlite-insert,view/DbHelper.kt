package com.example.myapplication3

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {

        private var DB_NAME: String = "User.db"
        private var TABLE_NAME: String = "info"
        private var ID: String = "id"
        private var NAME: String = "name"
        private var NUMBER: String = "number"
        private var DB_VERSION: Int = 1

    }


    override fun onCreate(p0: SQLiteDatabase?) {
        val create = ("CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
                + NUMBER + " TEXT" + ")")

        p0?.execSQL(create)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(p0)

    }

    fun savedata(m: Model): Long {
        var id: Long = 0

        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME, m.modelname)
        contentValues.put(NUMBER, m.modelnum)
        id = db.insert(TABLE_NAME, ID, contentValues)
        return id
    }


    fun viewdata(): List<Model?> {
        val arrayList: ArrayList<Model?> = ArrayList<Model?>()
        val db = readableDatabase
        val col = arrayOf(ID, NAME, NUMBER)
        val cursor = db.query(TABLE_NAME, col, null, null, null, null, null, null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val name = cursor.getString(1)
            val phn = cursor.getString(2)
            val user = Model()
            user.modelid = id
            user.modelname = name
            user.modelnum = phn
            arrayList.add(user)
        }

        return arrayList
    }
}