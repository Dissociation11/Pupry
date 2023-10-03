package com.example.pupry.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


//顶部栏组件
@Composable
//topAppBarHeight 默认 72dp(可调整)
fun TopAppBar(topAppBarHeight : Dp = 72.dp, content : @Composable BoxScope.() -> Unit){

    //顶部栏的内容居中放置，背景颜色为浅蓝绿渐变，后续可增加调整主题演示模块
    Box(modifier = Modifier
        .background(Brush.linearGradient(
            listOf(FirstColor, LastColor)))
        .fillMaxWidth()
        .height(topAppBarHeight)
    ){
        content()
    }
}


//顶部栏组件预览
@Preview
@Composable
fun TopAppBarPreview(){
    TopAppBar(){
        Text("hello world")
    }
}