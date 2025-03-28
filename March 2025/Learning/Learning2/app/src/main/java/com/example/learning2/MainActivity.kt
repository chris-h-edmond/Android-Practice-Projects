package com.example.learning2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learning2.ui.theme.Learning2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Learning2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // BMW
                        Box(modifier = Modifier
                            .weight(0.5f)
                            .padding(16.dp)
                        ){
                            ImageCard(
                                painter = painterResource(id = R.drawable.bmw),
                                contentDescription = "BMW on the road",
                                title = "BMW",
                            )
                        }

                        // Drawing
                        Box(modifier = Modifier
                            .weight(0.5f)
                            .padding(16.dp)
                        ){
                            ImageCard(
                                painter = painterResource(id = R.drawable.drawing),
                                contentDescription = "Drawing of SUS ",
                                title = "WATERMELON",

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
        painter: Painter,
        contentDescription: String,
        title: String,
        modifier: Modifier = Modifier
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 300f
                            )
                        )
                )
                Text(
                    text = title,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(12.dp),
                    fontSize = 16.sp,
                    style = TextStyle(Color.White),
                )
            }

        }
    }
