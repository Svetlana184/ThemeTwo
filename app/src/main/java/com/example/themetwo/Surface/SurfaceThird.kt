package com.example.themetwo.Surface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

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

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdPreview() {
    IndianFlag()
}