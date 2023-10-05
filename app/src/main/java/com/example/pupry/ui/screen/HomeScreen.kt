package com.example.pupry.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.pupry.R
import com.example.pupry.model.entity.ContentType
import com.example.pupry.model.entity.SongEntity
import com.example.pupry.ui.component.SearchText
import com.example.pupry.ui.component.SongBackground
import com.example.pupry.ui.component.SongItem
import com.example.pupry.ui.component.Swiper
import com.example.pupry.ui.component.TopAppBar
import com.example.pupry.ui.component.VideoItem
import com.example.pupry.viewmodel.MainViewModel
import com.example.pupry.viewmodel.SongViewModel
import com.example.pupry.viewmodel.VideoViewModel
import kotlinx.coroutines.selects.select


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier : Modifier = Modifier , viewModel : MainViewModel = viewModel() , songViewModel : SongViewModel = androidx.lifecycle.viewmodel.compose.viewModel() , videoViewModel : VideoViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    Column(modifier = modifier.fillMaxSize()) {

        TopAppBar {

            Icon(imageVector = Icons.Default.AccountCircle,"",
                modifier = Modifier
                    .size(56.dp)
                    .align(Alignment.CenterStart)
                    .padding(start = 10.dp)
                    .clickable { Unit })

            SearchText(modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.6f))

            Icon(imageVector = Icons.Default.Add,"",
                modifier = Modifier
                    .size(56.dp)
                    .align(Alignment.CenterEnd)
                    .padding(10.dp)
                    .clickable { Unit })

        }

        Column(){

            Box(){
                LazyColumn(){

                    item { Swiper(viewModel) }

                    item {
                        TabRow(selectedTabIndex = viewModel.selectedType){
                            viewModel.contentType.value.forEachIndexed{index, contentType ->
                                Tab(selected = viewModel.selectedType == index,onClick = {
                                    viewModel.selectedType = index
                                }){
                                    Text(contentType.type , modifier = Modifier.padding(6.dp))
                                }
                            }
                        }
                    }

                    when(viewModel.selectedType){
                        0 -> items(songViewModel.list){song ->
                            SongItem(song)
                        }
                        1 -> items(videoViewModel.list){video ->
                            VideoItem(video)
                        }
                    }

                }


            }

        }

    }
}


@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}