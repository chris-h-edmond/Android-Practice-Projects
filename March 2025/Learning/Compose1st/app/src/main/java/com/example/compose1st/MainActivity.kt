package com.example.compose1st

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.compose1st.ui.theme.Compose1stTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false) // Handle edge-to-edge properly
        setContent {
            Compose1stTheme {
                var name by remember { mutableStateOf("") }
                var names by remember { mutableStateOf(mutableListOf<Pair<String, Boolean>>()) }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            modifier = Modifier.weight(1f),
                            value = name,
                            onValueChange = { text -> name = text },
                            label = { Text("Enter name") }
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        modifier = Modifier.align(Alignment.End),
                        onClick = {
                            if (name.isNotBlank()) {
                                names = names.toMutableList().apply { add(name to false) }
                                name = ""
                            }
                        }
                    ) {
                        Text(text = "Add")
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    LazyColumn(
                        modifier = Modifier.weight(1f)
                    ) {
                        itemsIndexed(names) { index, (currentName, isChecked) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = isChecked,
                                    onCheckedChange = { checked ->
                                        names = names.toMutableList().apply {
                                            this[index] = this[index].copy(second = checked)
                                        }
                                    }
                                )
                                Text(
                                    text = currentName,
                                    modifier = Modifier.weight(1f),
                                    textDecoration = if (isChecked) TextDecoration.LineThrough else TextDecoration.None
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            names = names.filter { !it.second }.toMutableList()
                        }
                    ) {
                        Text(text = "Delete Selected")
                    }
                }
            }
        }
    }
}