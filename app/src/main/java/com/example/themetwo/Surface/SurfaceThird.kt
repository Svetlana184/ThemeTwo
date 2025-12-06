package com.example.themetwo.Surface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun SurfaceThird(){
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth().height(100.dp).padding(16.dp)
    ){
        val (yellow, circle, blue) = createRefs()
        Box(modifier = Modifier.fillMaxWidth().height(30.dp).
        background(Color.Red).constrainAs(yellow){
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        })
        Box(modifier = Modifier.fillMaxWidth().height(30.dp).
        background(Color.Blue).constrainAs(circle){
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            top.linkTo(yellow.bottom)
            bottom.linkTo(blue.top)
        })
        Box(modifier = Modifier.fillMaxWidth().height(30.dp).
        background(Color.Green).constrainAs(blue){
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
        })

    }

}

@Composable
fun IndianFlag(){
    val constrains = ConstraintSet(){
        val orangeBox = createRefFor(id = "orangeBox")
        val blueBox = createRefFor(id = "blueBox")
        val greenBox = createRefFor(id = "greenBox")
        constrain(orangeBox){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            height = Dimension.value(250.dp)
            width = Dimension.fillToConstraints
        }
        constrain(blueBox){
            top.linkTo(orangeBox.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            height = Dimension.value(100.dp)
            width = Dimension.value(100.dp)
        }
        constrain(greenBox){
            top.linkTo(blueBox.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            height = Dimension.value(100.dp)
            width = Dimension.fillToConstraints
            height = Dimension.value(250.dp)
        }
        createVerticalChain(orangeBox, blueBox, greenBox, chainStyle = ChainStyle.SpreadInside)
    }
    ConstraintLayout(constrains, modifier = Modifier.
    background(Color.White).fillMaxSize())
    {
        Box(modifier = Modifier.background(Color.Red).layoutId("orangeBox"))
        Box(modifier = Modifier.background(Color.Blue).layoutId("blueBox"))
        Box(modifier = Modifier.background(Color.Green).layoutId("greenBox"))
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdPreview() {
    IndianFlag()
}