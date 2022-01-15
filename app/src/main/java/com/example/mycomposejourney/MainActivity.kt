package com.example.mycomposejourney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Color(0xFFF2F2F2))
                .fillMaxWidth()
                .fillMaxHeight(.5f)
                .border(5.dp, Color.Magenta)
                .padding(20.dp)
                .border(1.dp, Color.Red)
                .padding(20.dp)
                .border(10.dp, Color.Blue)
                .padding(20.dp)
                .border(2.dp, Color.Yellow)
                .padding(30.dp)

            ) {
                Text("Bye Bye XML", modifier = Modifier
                    .offset(150.dp, 19.dp))
                Spacer(modifier = Modifier.height(50.dp))
                Text("Hey, Compose 🥰")
                Button(onClick = {  }, modifier = Modifier.offset(0.dp, 20.dp)) {
                    Text("Sweet Alert")
                }
            }


        }
    }
}
