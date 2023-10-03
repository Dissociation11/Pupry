package com.example.pupry.utils

import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

//JDBC工具类，用于连接MySQL数据库
object JDBCUtils{

    val DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver"
    val URL_PRE = "jdbc:mysql:"

    //传入数据生成连接所需的url
    fun getStatement(ip:String,port:String,database:String?,user:String,password:String): Statement {

        Class.forName(DRIVER_CLASS_NAME)

        var url = URL_PRE + "//" + ip + ":" + port

        Log.v("url",url)

        if(database != null){

            url += "/" + database
            Log.v("url + database",url)

        }

        var cn:Connection? = DriverManager.getConnection(url,user,password)

        if(cn == null){
            Log.v("ERR01","数据库连接失败")
        }

        var ps : Statement = cn!!.createStatement()

        return ps
    }

}