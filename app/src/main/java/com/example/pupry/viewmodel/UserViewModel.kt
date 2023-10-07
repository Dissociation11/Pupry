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
            return
        }

        if(password.isEmpty()){
            return
        }

        val userDao = UserDao(context)
        userDao.openDB()
        val user = userDao.query(username)
        userDao.closeDB()

        if(user == null){
            Log.v("err","user = null")
            return
        }

        if(!user.passWord.equals(password)){
            Log.v("err","password != passWord")
            return
        }

        userInfo = user

        onClose()
    }

    fun regest(context:Context,username : String,password : String,passwordAgain : String,onNavigateToLogin:()->Unit = {}){

        if(username.isEmpty()){ return }
        if(password.isEmpty() || passwordAgain.isEmpty()){ return }
        if(!password.equals(passwordAgain)){ return }

        val userDao = UserDao(context)
        userDao.openDB()
        userDao.insert(UserInfoEntity(username,password))
        userDao.closeDB()

        onNavigateToLogin()

    }

}