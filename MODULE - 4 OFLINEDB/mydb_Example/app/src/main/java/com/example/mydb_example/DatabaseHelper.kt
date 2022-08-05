package com.example.mydb_example

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.lang.Exception

class DatabaseHelper(var context:Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object{
        private final var DATABASE_NAME="mydb"
        private final var DATABASE_VERSION= 1

        private const val TABLE_NAME= "student"
        private const val KEY_ID = "Id"
        private const val KEY_USERNAME = "username"
        private const val KEY_EMAIL = "email"
        private const val KEY_PASSWORD ="password"
        private const val KEY_MOBILE="mobile"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE=("CREATE TABLE "+ TABLE_NAME+" ("+ KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + KEY_USERNAME +" TEXT, "+ KEY_EMAIL +" TEXT," + KEY_PASSWORD+" TEXT, "+ KEY_MOBILE +" TEXT )" )
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun insert(um:UserModel):Long
    {
        var db=this.writableDatabase
        var cv=ContentValues()

        cv.put(KEY_USERNAME,um.userName)
        cv.put(KEY_EMAIL,um.user_email)
        cv.put(KEY_PASSWORD,um.user_pass)
        cv.put(KEY_MOBILE,um.user_mobile)

        var insertIntoTable=db.insert(TABLE_NAME,null,cv)
        return insertIntoTable;

    }
    @SuppressLint("Range")
    fun getAllData():MutableList<UserModel>{
        var userList:MutableList<UserModel> =ArrayList()
        var sqlQuery:String="Select * from $TABLE_NAME"

        var db=this.readableDatabase
        var cursor:Cursor?
        try{
            cursor=db.rawQuery(sqlQuery,null)

        }
        catch (Exception:Exception)
        {
            Toast.makeText(this.context, ""+Exception, Toast.LENGTH_SHORT).show()
            return ArrayList()
        }
        var user_id:Int
        var userName:String
        var user_email:String
        var user_mobile:String
        var user_pass:String
        if (cursor.count>0){
            if(cursor.moveToFirst())
            {
                do{
                    user_id=cursor.getInt(cursor.getColumnIndex(KEY_ID))
                    userName=cursor.getString(cursor.getColumnIndex(KEY_USERNAME))
                    user_email=cursor.getString(cursor.getColumnIndex(KEY_EMAIL))
                    user_mobile=cursor.getString(cursor.getColumnIndex(KEY_MOBILE))
                    user_pass=cursor.getString(cursor.getColumnIndex(KEY_PASSWORD))
                    userList.add(UserModel(user_id,userName,user_email,user_pass,user_mobile))

                }while (cursor.moveToNext())
            }
        }
        return userList
    }
    fun updateData(um:UserModel):Int{
        var db=this.readableDatabase
        var cv=ContentValues()

        cv.put(KEY_USERNAME,um.userName)
        cv.put(KEY_EMAIL,um.user_email)
        cv.put(KEY_PASSWORD,um.user_pass)
        cv.put(KEY_MOBILE,um.user_mobile)
        var id=db.update(TABLE_NAME,cv, KEY_ID+"="+um.user_id,null)
        db.close()
        return id

    }
    fun DeleteUserData(um: UserModel):Int{
        var db=this.writableDatabase
        var delete_qry=db.delete(TABLE_NAME, KEY_ID+" = "+um.user_id,null)
        db.close()
        return delete_qry
    }


}