package com.example.pupry.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupry.R
import com.example.pupry.ui.component.MenuItemBackground
import com.example.pupry.ui.component.TopAppBar

@Composable
fun VersionInfoScreen(onClose : () -> Unit = {}){

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar {

            Icon(imageVector = Icons.Default.ArrowBack,"",
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterStart)
                    .padding(start = 10.dp)
                    .clickable {
                        onClose()
                    })

            Text(
                "版本信息",
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        LazyColumn(){

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                Column(modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .background(MenuItemBackground)
                    .clip(RoundedCornerShape(8.dp))) {
                    Divider()
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {

                        Icon(Icons.Default.Info, "", modifier = Modifier.size(28.dp))

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            "当前版本", color = Color(0xFF333333),
                            fontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )

                        Text(stringResource(id = R.string.app_version))

                    }
                    Divider()
                }
            }

        }

    }

}

@Preview
@Composable
fun VersionInfoPreview(){
    VersionInfoScreen()
}