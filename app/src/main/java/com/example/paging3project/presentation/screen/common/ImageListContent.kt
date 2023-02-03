package com.example.paging3project.presentation.screen.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.paging3project.R
import com.example.paging3project.datasource.local.entity.UnSplashImage
import com.example.paging3project.datasource.local.entity.UnSplashUrls
import com.example.paging3project.datasource.local.entity.UnSplashUser
import com.example.paging3project.datasource.local.entity.UnSplashUserLinks
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun ImageListContent(items: LazyPagingItems<UnSplashImage>, onClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            key = { unSplashImage ->
                unSplashImage.id
            }, items = items
        ) { unsplashImage ->
            unsplashImage?.let {
                UnSplashItem(it, onClick)
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun UnSplashItem(item: UnSplashImage, onClick: (String) -> Unit) {
    val painter = rememberImagePainter(data = item.unSplashUrls?.regular) {
        crossfade(durationMillis = 500)
        error(R.drawable.ic_place_holder)
        placeholder(R.drawable.ic_place_holder)
    }

    Box(modifier = Modifier
        .clickable {
            item.unSplashUrls?.full?.let {
                val encodedUrl = URLEncoder.encode(it, StandardCharsets.UTF_8.toString())
                onClick(encodedUrl)
            }
        }
        .height(300.dp)
        .fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Image(
            painter = painter,
            contentDescription = "Image description",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(ContentAlpha.medium),
            color = Color.Black

        ) {
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
                ) {
                Text(
                    text = buildAnnotatedString {
                        append("Photo by")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                            item.unSplashUser?.userName?.let { append(it) }!!
                        }
                        append(" on Unsplash")
                    },
                    color = Color.White,
                    fontSize = MaterialTheme.typography.caption.fontSize,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                LikeCounter(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.ic_heart),
                    likes = "${item.likes}"
                )
            }
        }
    }
}

@Composable
fun LikeCounter(
    modifier: Modifier, painter: Painter, likes: String
) {
    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            painter = painter, contentDescription = "Heart Icon", tint = Color.Red
        )
        Divider(modifier = Modifier.width(6.dp))
        Text(
            text = likes,
            color = Color.White,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun Preview() {
    LazyColumn {
        items(5) {
            UnSplashItem(
                item = UnSplashImage(
                    "", UnSplashUrls("", ""), 12, UnSplashUser(UnSplashUserLinks(""), "")
                )
            ) {}
        }
    }
}