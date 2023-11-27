package com.angelika.jetpackcomposelesson4.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.angelika.jetpackcomposelesson4.presentation.screens.AnimeListColumn
import com.angelika.jetpackcomposelesson4.ui.theme.JetpackComposeLesson4Theme
import com.angelika.jetpackcomposelesson4.ui.theme.KitsuColor1
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLesson4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimeListColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(KitsuColor1)
                            .padding(14.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeLesson4Theme {
        AnimeListColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(KitsuColor1)
                .padding(14.dp)
        )
    }
}