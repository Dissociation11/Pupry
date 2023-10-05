package com.example.pupry.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.pupry.model.entity.VideoEntity

@Composable
fun VideoItem(video : VideoEntity){

    var constraintSet = ConstraintSet{

        val title = createRefFor("title")
        val type = createRefFor("type")
        val duration = createRefFor("duration")
        val cover = createRefFor("cover")

        constrain(cover){
            start.linkTo(parent.start, margin = 8.dp)
            centerVerticallyTo(parent)
            width = Dimension.value(145.dp)
        }

        constrain(title){
            start.linkTo(cover.end, margin = 8.dp)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }

        constrain(type){
            start.linkTo(title.start)
            bottom.linkTo(parent.bottom, margin = 2.dp)
        }

        constrain(duration){
            end.linkTo(parent.end , margin = 20.dp)
            bottom.linkTo(parent.bottom, margin = 2.dp)
        }


    }

    ConstraintLayout(constraintSet ,
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp,4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(VideoBackground)){

        AsyncImage(model = "https://img0.baidu.com/it/u=1986648698,1125087642&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500",
            contentDescription = null,
            modifier = Modifier.layoutId("cover")
                .aspectRatio(16/9f).padding(4.dp))

        Text(text = video.title,
            fontSize = 22.sp,
            color = Color(0xFF000000),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("title")
            )

        Text(text = video.type,
            fontSize = 16.sp,
            color = Color(0xFF000000),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("type")
        )

        Text(text = "时长:${video.duration}",
            fontSize = 16.sp,
            color = Color(0xFF000000),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("duration")
        )
    }

}

@Preview
@Composable
fun VideoItemPreview(){
    VideoItem(VideoEntity("title","type","duration","Test"))
}
