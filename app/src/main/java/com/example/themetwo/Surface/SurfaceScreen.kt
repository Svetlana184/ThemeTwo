package com.example.themetwo.Surface

import android.R.attr.top
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.themetwo.Greeting
import com.example.themetwo.R
import com.example.themetwo.ui.theme.ThemeTwoTheme

@Composable
fun SurfaceScreen(){
    Card(modifier = Modifier.fillMaxWidth().padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(8.dp)
    ){
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth().height(100.dp).padding(16.dp)
        ) {
            val (profileImage, name, tagline, followButton) = createRefs()
            Image(painter = painterResource(id=R.drawable.ic_launcher_foreground),
                contentDescription = "profile image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(48.dp).clip(CircleShape)
                    .constrainAs(profileImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    })
            Text(text = "Karishma agrawal", style = MaterialTheme.typography.
            titleMedium.copy(fontSize = 16.sp), fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(name){
                    start.linkTo(profileImage.end, margin = 12.dp)
                    top.linkTo(profileImage.top)
                })
            Text(text = "Android Engineer",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.sp),
                modifier = Modifier.constrainAs(tagline){
                    start.linkTo(name.start)
                    top.linkTo(name.bottom, margin = 4.dp)
                })
            Button(onClick = {},
                modifier = Modifier.constrainAs(followButton){
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(parent.top)
                }
                ) { }


        }
    }
    val (profileImage, name, tagline, followButton) = createRefs()
//    ConstraintLayout(
//        Modifier.fillMaxSize()
//    ) {
//        val rect = createRef()
//        Box(Modifier.size(200.dp).background(Color.DarkGray).constrainAs(rect) {
//            top.linkTo(parent.top, margin = 16.dp)
//        })
//        val (text1, text2) = createRefs()
//
//        Text("TV", fontSize = 54.sp, modifier = Modifier.constrainAs(text1) {
//            centerHorizontallyTo(parent)
//            top.linkTo(parent.top)
//            bottom.linkTo(text2.top)
//        })
//
//        Text("Radio", fontSize = 54.sp, modifier = Modifier.constrainAs(text2) {
//            centerHorizontallyTo(parent)
//            top.linkTo(text1.bottom)
//            bottom.linkTo(parent.bottom)
//        })
//
//    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        SurfaceScreen()
}