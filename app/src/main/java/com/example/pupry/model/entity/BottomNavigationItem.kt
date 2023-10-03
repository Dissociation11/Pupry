package com.example.pupry.model.entity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigationItem(val title : String, val icon : ImageVector){
    Home("Home", Icons.Default.Home),
    Add("Add",Icons.Default.Add),
    Account("Account",Icons.Default.AccountCircle)
}