package com.example.pupry.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLiteHelpr(context : Context, name:String, version:Int) : SQLiteOpenHelper(context,name,null,version) {

    private val CREATE_USER_TABLE = "create table if not exists User(" +
            "id Integer primary key autoincrement," +
            "username text not null unique,"+
            "password text not null)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_USER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


}