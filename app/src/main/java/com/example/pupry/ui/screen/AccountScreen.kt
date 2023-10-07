package com.example.pupry.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupry.R
import com.example.pupry.compositionLocal.LocalUserViewModel
import com.example.pupry.ui.component.MenuItemBackground
import com.example.pupry.ui.component.TopAppBar
import com.example.pupry.ui.component.UserTabBackground

@Composable
fun AccountScreen(modifier : Modifier = Modifier,onNavigateToLogin:()->Unit = {}){

    val userViewModel = LocalUserViewModel.current

    val menus = listOf(
        MenuItem(Icons.Default.Settings,"个人设置"),
        MenuItem(Icons.Default.Info,"版本信息"),
        MenuItem(Icons.Default.Phone,"联系我们")
    )

    Column(modifier = modifier.fillMaxSize()){

        TopAppBar {
            Text("我的",
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Center))
        }

        LazyColumn(){

            item {
                Box(modifier = Modifier
                    .padding(6.dp)
                    .background(UserTabBackground)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        onNavigateToLogin.invoke()
                    }){
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ){

                        Image(painterResource(id = R.drawable.redprince),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(65.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.width(30.dp))

                        Column(verticalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .height(65.dp)){
                            Text(text = if(userViewModel.logined) userViewModel.userInfo!!.userName else "未登录",
                                fontSize = 20.sp)
                            Text(text = if(userViewModel.logined) "普通用户" else "点击前往登录")
                        }

                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }

            items(menus){menu ->
                Column(modifier = Modifier.padding(horizontal = 4.dp)
                    .background(MenuItemBackground)
                    .clip(RoundedCornerShape(8.dp))){
                    Divider()
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)){

                        Icon(menu.icon,menu.title,modifier = Modifier.size(28.dp))

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(menu.title,color = Color(0xFF333333),
                            fontSize = 16.sp,
                            modifier = Modifier.weight(1f))

                        Icon(imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier)

                    }
                    Divider()
                }
            }

        }
    }
}

data class MenuItem(val icon : ImageVector,val title : String)

@Preview
@Composable
fun AccountScreenPreview(){
    AccountScreen()
}