package com.example.themetwo.Surface

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun SurfaceScreenSecond(){
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth().height(100.dp).padding(16.dp)
        ){
            val (button, text, progressBar) = createRefs()
            Button(onClick = {},
                modifier = Modifier.constrainAs(button){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {Text("Button") }
            Text("Text", Modifier.constrainAs(text){
                top.linkTo(button.bottom, margin = 16.dp)
            })
            LinearProgressIndicator(
                progress = 0.60F,
                modifier = Modifier.height(10.dp).constrainAs(progressBar){
                    start.linkTo(text.end, margin = 8.dp)
                    top.linkTo(text.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(text.bottom)
                }
            )
        }

}

@Preview(showBackground = true)
@Composable
fun SurfacePreview() {
    SurfaceScreenSecond()
}