package com.example.mycomposejourney

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraintSet = ConstraintSet {
                val blueBox = createRefFor(1)
                val greenBox = createRefFor(2)
                val yellowBox = createRefFor(3)
                val redBox = createRefFor(4)
                val magentaBox = createRefFor(5)
                val cyanBox = createRefFor(6)

                constrain(blueBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.value(150.dp)
                    height = Dimension.fillToConstraints
                }

                constrain(greenBox) {
                    bottom.linkTo(parent.bottom)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    width = Dimension.value(150.dp)
                    height = Dimension.fillToConstraints
                }

                constrain(redBox) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.value(150.dp)
                    height = Dimension.value(150.dp)
                }

                constrain(yellowBox) {
                    top.linkTo(redBox.top)
                    bottom.linkTo(redBox.bottom)
                    start.linkTo(redBox.end)
                    width = Dimension.value(150.dp)
                    height = Dimension.value(150.dp)
                }

                constrain(magentaBox) {
                    start.linkTo(greenBox.start)
                    end.linkTo(greenBox.end)
                    top.linkTo(parent.top)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(150.dp)
                }

                constrain(cyanBox) {
                    start.linkTo(blueBox.start)
                    end.linkTo(blueBox.end)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(150.dp)
                }

                createHorizontalChain(redBox, yellowBox, chainStyle = ChainStyle.Spread)

            }

            ConstraintLayout(constraintSet, modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .background(Color.Blue)
                        .layoutId(1)
                )
                {

                }

                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .layoutId(2)
                ) {

                }

                Box(
                    modifier = Modifier
                        .background(Color.Yellow)
                        .layoutId(3)
                )
                {

                }

                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .layoutId(4)
                )
                {

                }

                Box(modifier = Modifier
                    .background(Color.Magenta)
                    .layoutId(5))
                {

                }

                Box(modifier = Modifier
                    .background(Color.Cyan)
                    .layoutId(6))
                {

            LazyColumn {
                items(200) {
                    Text(
                        text = "Android $it",
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                            .fillMaxWidth(),
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("$textFieldState is your girlfriend right? 😂", "Yes")
                        }
                    }) {
                        Text("Click me to see a magic")
            val painter1 = painterResource(id = R.drawable.pasta)
            val painter2 = painterResource(id = R.drawable.happy_meal_small)
            val description = "Italian pasta"
            val title1 = "Respondo Pasta"
            val title2 = "Happy Meal"
            val price = "$5"

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Compose Recipe", style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Monospace))
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    ImageCard(painter1, title1, price, description)
                    Spacer(modifier = Modifier.height(20.dp))
                    ImageCard(painter2, title2, price, description)
                    Spacer(modifier = Modifier.height(50.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                Toast.makeText(this@MainActivity, "", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.height(50.dp)
                        ) {
                            Text("More Meals 😋")
                        }
                    }
                }
            }
        }
    }
}
}

@Composable
fun ImageCard(
    painter: Painter,
    title: String,
    price: String,
    contentDes: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDes,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 350f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {

                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(title, style = TextStyle(color = Color.White, fontSize = 18.sp))
                    Text(price, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }

            }
        }
    }
}
