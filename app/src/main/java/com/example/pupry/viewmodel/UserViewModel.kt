package com.example.pupry.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.pupry.DB.UserDao
import com.example.pupry.model.entity.UserInfoEntity

class UserViewModel : ViewModel() {

    var userInfo : UserInfoEntity? = null
        private set

    val logined : Boolean
        get(){
            return userInfo != null
        }

    fun login(context: Context,onClose:() -> Unit = {},username: String,password: String){

        if(username.isEmpty()){
            Toast.makeText(context,"用户名不可为空!",Toast.LENGTH_SHORT).show()
            return
        }

        if(password.isEmpty()){
            Toast.makeText(context,"密码不可为空!",Toast.LENGTH_SHORT).show()
            return
        }

        val userDao = UserDao(context)
        userDao.openDB()
        val user = userDao.query(username)
        userDao.closeDB()

        if(user == null){
            Toast.makeText(context,"用户名不存在!",Toast.LENGTH_SHORT).show()
            return
        }

        if(!user.passWord.equals(password)){
            Toast.makeText(context,"密码错误!",Toast.LENGTH_SHORT).show()
            return
        }

        userInfo = user

        onClose()
    }

    fun regest(context:Context,username : String,password : String,passwordAgain : String,onNavigateToLogin:()->Unit = {}){

        if(username.isEmpty()){
            Toast.makeText(context,"用户名不可为空!",Toast.LENGTH_SHORT).show()
            return
        }
        if(username.length < 4){
            Toast.makeText(context,"用户名必须大于4位!",Toast.LENGTH_SHORT).show()
            return
        }
        if(username.length > 25){
            Toast.makeText(context,"用户名不得大于25位!",Toast.LENGTH_SHORT).show()
            return
        }
        if(password.isEmpty() || passwordAgain.isEmpty()){
            Toast.makeText(context,"密码不可为空!",Toast.LENGTH_SHORT).show()
            return
        }
        if(password.length < 6){
            Toast.makeText(context,"密码必须大于6位!",Toast.LENGTH_SHORT).show()
            return
        }

        if(password.length > 18){
            Toast.makeText(context,"密码不得大于18位!",Toast.LENGTH_SHORT).show()
            return
        }

        if(!password.equals(passwordAgain)){
            Toast.makeText(context,"两次输入密码不一致",Toast.LENGTH_SHORT).show()
            return
        }

        val userDao = UserDao(context)
        userDao.openDB()
        userDao.insert(UserInfoEntity(username,password))
        userDao.closeDB()

        onNavigateToLogin()

    }

}