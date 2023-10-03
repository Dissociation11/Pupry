package com.example.pupry

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupry.utils.SQLTest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize()){
                    Button(onClick = {
                        Thread(Runnable {
                            val st = SQLTest()
                            st.connection()
                        }).start()
                    }) {
                        Text("Test")
                    }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun previewTest() {
    Box(modifier = Modifier.fillMaxSize()){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)){

            Image(painter = painterResource(id = R.drawable.ic_launcher_background),"testIcon")

            Spacer(modifier = Modifier.height( 20.dp ))

            TextField(
                modifier = Modifier.clip(shape = CircleShape),
                value = "",
                onValueChange = { Unit },
                leadingIcon = { Image(
                    painter = painterResource(id = R.drawable.username),
                    contentDescription = "userNmaeIcon",
                    modifier = Modifier) },
                placeholder = { Text("") },
                textStyle = TextStyle(fontSize = 20.sp),
                maxLines = 1
            )

            Spacer(modifier = Modifier.height( 8.dp ))

            TextField(
                modifier = Modifier.clip(shape = CircleShape),
                value = "",
                onValueChange = { Unit },
                leadingIcon = { Image(
                    painter = painterResource(id = R.drawable.password),
                    contentDescription = "userNmaeIcon",
                    modifier = Modifier) },
                placeholder = { Text("") },
                textStyle = TextStyle(fontSize = 20.sp),
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(){
                Button(
                    modifier = Modifier,
                    onClick = {

                    }){
                    Text("登录")
                }

                Spacer(modifier = Modifier.width(20.dp))

                Button(
                        modifier = Modifier,
                onClick = {

                }){
                Text("注册")
                }
            }


            Spacer(modifier = Modifier.fillMaxSize(0.5f))

        }
    }
}