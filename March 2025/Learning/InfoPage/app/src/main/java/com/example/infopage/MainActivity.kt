package com.example.infopage

import android.os.Bundle
import android.util.EventLogTags.Description
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.infopage.ui.theme.InfoPageTheme

private const val Main_Heading = "JetPack Compose Stuff"
private const val Introduction = "Jetpack Compose is a modern toolkit for building native Android UI.Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs."
private const val Main_Description = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InfoPageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ){
                        //BANNER IMAGE
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                            modifier = Modifier
                                .fillMaxWidth(),
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.bday),
                                contentDescription = "Header banner",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp),
                                contentScale = ContentScale.Crop,
                            )
                        }

                        // HEADING
                        Text(
                            modifier = Modifier
                                .padding(16.dp),
                            text = Main_Heading,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                        )
                        // SubHeading
                        Text(
                            modifier = Modifier
                                .padding(16.dp),
                            text = Introduction,
                            textAlign = TextAlign.Justify,
                        )

                        // Description
                        Text(
                            modifier = Modifier
                                .padding(16.dp),
                            text = Main_Description,
                            textAlign = TextAlign.Justify,
                        )
                    }

                }
            }
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
    InfoPageTheme {
        Greeting("Android")
    }
}