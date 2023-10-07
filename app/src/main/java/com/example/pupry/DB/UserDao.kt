package com.example.pupry.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.pupry.model.entity.UserInfoEntity

class UserDao(context : Context) {

    val SQLhelper = MySQLiteHelpr(context,"user.db",1)
    lateinit var db: SQLiteDatabase

    fun openDB(){
        db = SQLhelper.writableDatabase
    }

    fun closeDB(){
        if(db != null) SQLhelper.close()
    }

    fun insert(user : UserInfoEntity){
        val values = ContentValues().apply {
            put("username",user.userName)
            put("password",user.passWord)
        }
        db.insert("User",null,values)
    }

    fun delete(user:UserInfoEntity){
        db.delete("User","username = ?", arrayOf(user.userName))
    }

    fun update(user : UserInfoEntity){
        val values = ContentValues().apply {
            put("username",user.userName)
            put("password",user.passWord)
        }
        db.update("User",values,"username = ?", arrayOf(user.userName))
    }

    fun query(username:String):UserInfoEntity?{

        val projection : Array<String> = arrayOf("username","password")
        val selection : String = "username = ?"
        val selectionArgs : Array<String> = arrayOf(username)

        val cursor = db.query("User",projection,selection,selectionArgs,null,null,null)

        var user : UserInfoEntity? = null

        Log.v("cursor","run")

        if(cursor.moveToFirst()){

            Log.v("cursor","run1")

            var userName = cursor.getString(cursor.getColumnIndexOrThrow("username"))
            var passWord = cursor.getString(cursor.getColumnIndexOrThrow("password"))

            user = UserInfoEntity(userName,passWord)
        }

        cursor.close()

        return user

    }

}