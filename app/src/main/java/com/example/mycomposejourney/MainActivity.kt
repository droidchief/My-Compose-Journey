package com.example.mycomposejourney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCompose()
        }
    }
}

var i = 0
@Composable
fun MyCompose() {
    Button(onClick = {
        i++
    }) {
        Text(text = "$i")
    }
}