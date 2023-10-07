package com.example.pupry.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.pupry.viewmodel.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Swiper(viewModel : MainViewModel){

    var virtualCount = Int.MAX_VALUE

    var actualCount = viewModel.swiperData.size

    var initialIndex = virtualCount/2

    var pagerState = rememberPagerState(initialPage = initialIndex)

    HorizontalPager(
        pageCount = virtualCount,
        state = pagerState,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(8.dp))) { index ->

        val actualIndex = (index - initialIndex).floorMod(actualCount)

        AsyncImage(
            model = viewModel.swiperData[actualIndex].imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16/9f),
            contentScale = ContentScale.Crop
        )
    }

}

private fun Int.floorMod(other : Int) : Int = when(other){
    0 -> 0
    else -> this - floorDiv(other) * other
}

@Preview
@Composable
fun SwiperPreview(){
    Swiper(viewModel())
}