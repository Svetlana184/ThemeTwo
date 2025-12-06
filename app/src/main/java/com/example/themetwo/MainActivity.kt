package com.example.themetwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.themetwo.Surface.Example4
import com.example.themetwo.ui.theme.ThemeTwoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Example4()
            //1 вариант
            //var count = remember { mutableStateOf(0) }
            //2 вариант
            //var count by remember { mutableStateOf(0) }
            //3 вариант
//            var (count, setValue) = remember { mutableStateOf(0) }
//            Box(contentAlignment = Alignment.Center){
//                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
//                    ) {
//                    Text("Clicks : ${setValue(++count)}", fontSize = 28.sp)
//                    Button(onClick = {count++}) {
//                        Text("Click me!")
//                    }
//                }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThemeTwoTheme {
        Greeting("Android")
    }
}