package com.example.pupry.model.entity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigationItem(val title : String, val icon : ImageVector){
    Home("主页", Icons.Default.Home),
    Add("本地",Icons.Default.Archive),
    Account(" 我的",Icons.Default.AccountCircle)
}