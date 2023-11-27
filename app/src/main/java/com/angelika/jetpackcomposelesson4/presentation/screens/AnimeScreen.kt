package com.angelika.jetpackcomposelesson4.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angelika.jetpackcomposelesson4.R
import com.angelika.jetpackcomposelesson4.ui.theme.Grey
import com.angelika.jetpackcomposelesson4.ui.theme.KitsuColor2
import com.angelika.jetpackcomposelesson4.ui.theme.KitsuColor3
import com.angelika.jetpackcomposelesson4.ui.theme.KitsuColor4

@Composable
fun UserInfo(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row {
            Image(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.image_no_name),
                contentDescription = stringResource(R.string.content_description_user_image),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(top = 2.dp, start = 6.dp)
            ) {
                Text(
                    text = stringResource(R.string.text_welcome_back),
                    color = KitsuColor2,
                    fontSize = 12.sp
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = stringResource(R.string.user_name_li5_47),
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
        Image(
            modifier = Modifier
                .align(Alignment.CenterEnd),
            painter = painterResource(id = R.drawable.image_bell),
            contentDescription = stringResource(R.string.content_description_notifications),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(modifier: Modifier) {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            unfocusedIndicatorColor = KitsuColor4,
            containerColor = KitsuColor4
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = stringResource(
                    R.string.content_description_search_icon
                ),
                tint = KitsuColor3
            )
        },
        label = {
            Text(text = stringResource(R.string.search_kitsu), color = KitsuColor3)
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = stringResource(R.string.content_description_filter_icon),
                tint = Grey
            )
        }
    )
}

@Composable
fun TheBestAnime(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.text_the_best_anime),
        fontSize = 18.sp,
        color = Color.White
    )
}