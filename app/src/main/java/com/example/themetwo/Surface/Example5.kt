package com.example.themetwo.Surface

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.themetwo.R

@Composable
fun Example5(){
    val fruitList = mutableListOf<Game>()
    fruitList.add(Game("Apple", image = R.drawable.apple, ratings = 5))
    fruitList.add(Game("Lime", image = R.drawable.lime, ratings = 5))
    fruitList.add(Game("Strawberry", image = R.drawable.strawberry, ratings = 5))
    fruitList.add(Game("Watermelon", image = R.drawable.watermelon, ratings = 5))
    Scaffold(topBar = {
        @OptIn(ExperimentalMaterial3Api::class)
        (TopAppBar(title = {Text("Films", fontSize = 22.sp)},
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray, titleContentColor = Color.LightGray)))
    }) {
//        content = {
//            LazyVerticalGrid(
//                2
//            ) { }
//        }
    }
}

@Composable
fun GameItem(model: Game){
    Card(modifier = Modifier.background(Color.Black).padding(16.dp).clip(
        RoundedCornerShape(10.dp)).height(250.dp).fillMaxWidth()) {
        ConstraintLayout() {
            val (image, name, ratings) = createRefs()
            Image(painter = painterResource(id=model.image),
                contentDescription = "",
                contentScale = ContentScale.Crop, modifier = Modifier.constrainAs(image){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            Text(text = model.name, color = Color.Black, maxLines = 2, fontSize = 20.sp,
                fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(name){
                top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
            }.fillMaxSize().padding(8.dp))
            Row(modifier = Modifier.fillMaxWidth().constrainAs(ratings){
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {

                Text(text = model.ratings.toString(), color = Color.Black, modifier = Modifier.padding(8.dp), fontSize = 18.sp)
                Image(painter = painterResource(R.drawable.apple), contentDescription = "",
                    contentScale = ContentScale.Crop, modifier = Modifier.padding(top = 10.dp))
            }
        }
    }
}

data class Game(var name: String, var image: Int, var ratings: Int)

@Preview(showBackground = true)
@Composable
fun FifthPreview() {
    Example5()
}