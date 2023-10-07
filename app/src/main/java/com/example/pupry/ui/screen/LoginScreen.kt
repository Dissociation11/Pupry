package com.example.pupry.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupry.R
import com.example.pupry.compositionLocal.LocalUserViewModel
import com.example.pupry.ui.component.LoginBgFirst
import com.example.pupry.ui.component.LoginBgLast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onClose:() -> Unit = {},onNavigateToRegest:()->Unit={}){

    val userViewModel = LocalUserViewModel.current

    var screenWidth : Float
    var screenHeight : Float
    with(LocalDensity.current){
        screenWidth = LocalConfiguration.current.screenWidthDp.dp.toPx()
        screenHeight = LocalConfiguration.current.screenHeightDp.dp.toPx()
    }

    var userName by remember{
        mutableStateOf("")
    }

    var password by remember{
        mutableStateOf("")
    }

    var showPassword by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()){

        val context = LocalContext.current

        Image(painter = painterResource(id = R.drawable.seville),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())

        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(LoginBgFirst, LoginBgLast),
                    start = Offset(x = screenWidth, y = 0f),
                    end = Offset(x = 0f, y = screenHeight)
                )
            )){

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)){

                Spacer(modifier = Modifier.height(0.dp))

                Text(text = "用户登录",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    )

                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()){

                    TextField(value = userName,
                        onValueChange = {userName = it},
                        singleLine = true,
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = Color.White) },
                        label = {
                            Text("用户名",color = Color.White, fontSize = 14.sp) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.LightGray,
                            unfocusedIndicatorColor = Color.LightGray,
                            focusedLabelColor = Color.LightGray,
                            unfocusedLabelColor = Color.LightGray,
                            cursorColor = Color.White)
                    )

                    TextField(value = password,
                        onValueChange = {password = it},
                        singleLine = true,
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock,
                                contentDescription = null,
                                tint = Color.White) },
                        visualTransformation = if(showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            Icon(imageVector = if(showPassword) Icons.Default.KeyboardArrowLeft else Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                modifier = Modifier.clickable {
                                    showPassword = !showPassword
                                },
                                tint = Color.White)},
                        label = {
                            Text("密码",color = Color.White, fontSize = 14.sp) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.LightGray,
                            unfocusedIndicatorColor = Color.LightGray,
                            focusedLabelColor = Color.LightGray,
                            unfocusedLabelColor = Color.LightGray,
                            cursorColor = Color.White)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TextButton(onClick = {
                        userViewModel.login(context,onClose = onClose,userName,password)
                    }) {
                        Text("登录",
                            color = Color.White,
                            fontSize = 24.sp)
                    }

                }

                Spacer(modifier = Modifier.height(0.dp))

                TextButton(onClick = {
                    onNavigateToRegest.invoke()
                }) {
                    Text("还没有账号？点击立即注册",
                        color = Color.LightGray,
                        fontSize = 14.sp)
                }

                Spacer(modifier = Modifier.height(0.dp))

            }

        }

    }

}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}