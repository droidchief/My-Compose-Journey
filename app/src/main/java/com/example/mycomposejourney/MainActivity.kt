package com.example.mycomposejourney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                val color = remember {
                    mutableStateOf(Color.Yellow)
                }
                ColorChangerBox(
                    Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    color.value = it
                }

                Box(
                    modifier = Modifier
                        .background(color.value)
                        .fillMaxSize()
                        .weight(1f)
                ) {

                }
            }
        }
    }
}


@Composable
fun ColorChangerBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {

    Box(
        modifier
            .background(Color.Blue)
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            }) {

    }
}


