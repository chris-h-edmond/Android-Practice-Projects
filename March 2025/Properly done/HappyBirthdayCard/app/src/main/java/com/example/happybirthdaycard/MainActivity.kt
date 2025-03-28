package com.example.happybirthdaycard

import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthdaycard.ui.theme.HappyBirthdayCardTheme
import kotlin.random.Random


public val back_color = mutableStateOf(Color(0x80A596E2))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayCardTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 25.dp)
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .padding(top = 30.dp , start = 15.dp, end = 15.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        color = back_color.value,
                    ) {
                        Column(modifier = Modifier
                            .padding(30.dp),
                        ) {
                            ImageCard(
                                painter = painterResource(id = R.drawable.cake),
                                contentDescription = "nn",
                                title = "Happy Birthday" ,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ImageCard(
    painter : Painter ,
    contentDescription : String ,
    title : String ,
){
    var inputText by remember { mutableStateOf("") }

    var outputText by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Card(
            modifier = Modifier
                .width(250.dp)
                .height(250.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        ) {
            Image(
                painter = painter ,
                contentDescription = contentDescription,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit,
            )
        }

        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .width(250.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        ) {
            TextField(
                value = outputText, // Use the string directly
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle( // Use textStyle for formatting
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    color = Color.Black,
                    textAlign = TextAlign.End
                )
            )

            }


        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .width(250.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        ) {
            TextField(
                value = inputText,
                onValueChange = {
                    // Update input text as user types
                    inputText = it

                    outputText = it
                },
                label = { Text("Enter Text") },
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}
