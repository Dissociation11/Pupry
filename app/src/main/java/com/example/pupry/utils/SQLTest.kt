package com.example.pupry.utils

import android.util.Log
import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager

class SQLTest {
    fun connection(){
        try {

            val ps = JDBCUtils.getStatement("192.168.1.116","3306","Test","root","guet104")

            val result = ps.execute("create database TestXX;")

            if(result){
                Log.v("Test","XXX")
            }


            if (ps != null) {
                ps.close()
            }
        } catch (e : Exception){
            e.printStackTrace()
        }
    }
}