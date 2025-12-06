package com.example.themetwo.Surface

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.themetwo.R

@Composable
fun Example4(){
    val fruitList = mutableListOf<FruitModel>()
    fruitList.add(FruitModel("Apple", image = R.drawable.apple))
    fruitList.add(FruitModel("Lime", image = R.drawable.lime))
    fruitList.add(FruitModel("Strawberry", image = R.drawable.strawberry))
    fruitList.add(FruitModel("Watermelon", image = R.drawable.watermelon))
    LazyColumn() {
        items(fruitList){
            model->ListRow(model = model)
        }
    }
//    val countryList = mutableListOf<String>("Russia", "France", "Poland", "Canada")
//    val listModifier = Modifier.fillMaxSize().background(Color.Gray).padding(10.dp)
//    LazyColumn(modifier = listModifier)
//    {
//        items(countryList){country ->
//            Text(text = country, fontSize = 20.sp, color = Color.White)
//        }
//    }
//    LazyColumn()
//    {
//        item { Text(text = "Header") }
//        items(3) {
//            index -> Text(text = "First list item $index")
//        }
//        items(2){
//                index -> Text(text = "Second list item $index")
//        }
//        item { Text(text = "Footer") }
//    }

}

@Composable
fun ListRow(model: FruitModel){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.wrapContentHeight().fillMaxSize().background(Color.DarkGray)
        ) {
        Image(painter = painterResource(id=model.image), contentDescription = "",
            contentScale = ContentScale.Crop, modifier = Modifier
                .size(100.dp).padding(5.dp))
        Text(text = model.name, fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
    }
}
data class FruitModel(var name: String, var image: Int){}
@Preview(showBackground = true)
@Composable
fun FourthPreview() {
    Example4()
}