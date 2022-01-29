package com.example.mycomposejourney

import android.os.Bundle
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

                }
            }
        }
    }
}