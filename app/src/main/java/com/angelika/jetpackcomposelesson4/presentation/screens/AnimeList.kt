package com.angelika.jetpackcomposelesson4.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.angelika.jetpackcomposelesson4.R
import com.angelika.jetpackcomposelesson4.models.KitsuModel
import com.angelika.jetpackcomposelesson4.ui.theme.KitsuColor1
import com.angelika.jetpackcomposelesson4.ui.theme.Yellow
import com.angelika.jetpackcomposelesson4.ui.theme.transparentBlack

@Composable
fun AnimeListColumn(modifier: Modifier = Modifier,viewModel: AnimeListViewModel = hiltViewModel()) {

    val stateData = viewModel.animeState.collectAsState()

    Box(
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(top = 20.dp)) {
            UserInfo(modifier = Modifier.fillMaxWidth())
            Search(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            )
            TheBestAnime(modifier = Modifier.padding(10.dp))
            LazyVerticalGrid(
                columns = GridCells.Adaptive(140.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(stateData.value) { anime ->
                    AnimeItem(
                        anime = anime, modifier = Modifier
                            .clip(shape = RoundedCornerShape(15.dp))
                            .size(height = 180.dp, width = 140.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AnimeItem(modifier: Modifier = Modifier, anime: KitsuModel) {
    Box(
        modifier = modifier
    ) {
        AsyncImage(
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalContext.current)
                .data(anime.attributes.posterImage.large)
                .crossfade(true).build(),
            contentDescription = stringResource(R.string.content_description_image_anime),
            placeholder = painterResource(
                id = R.drawable.image_not_found,
            ),
        )
        Row(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.TopEnd)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(Color(transparentBlack.value))
                .padding(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 4.dp),
                text = anime.attributes.averageRating.toString(),
                fontSize = 10.sp,
                color = Color.White
            )
            Icon(
                modifier = Modifier
                    .padding(start = 2.dp),
                painter = painterResource(id = R.drawable.ic_rating),
                contentDescription = stringResource(R.string.content_description_icon_rating_anime),
                tint = Yellow
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 12.dp, bottom = 8.dp)
                .wrapContentSize()
                .align(Alignment.BottomStart),

            ) {
            Text(
                text = anime.attributes.title.enJp,
                color = Color.White,
                fontSize = 14.sp
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.padding(end = 6.dp),
                    painter = painterResource(id = R.drawable.ic_tv),
                    contentDescription = stringResource(R.string.content_description_location_image),
                    tint = Color.White
                )
                Text(
                    text = anime.attributes.status,
                    color = Color.White,
                    fontSize = 10.sp
                )
            }
        }
    }
}