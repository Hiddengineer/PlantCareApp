package com.example.plantcareapp.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plantcareapp.Greeting
import com.example.plantcareapp.android.MyApplicationTheme
import com.example.plantcareapp.android.ui.components.VideoPlayer // Import your VideoPlayer composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent()
                }
            }
        }
    }
}

@Composable
fun AppContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Video Player in the top section
        VideoPlayer(videoUri = "android.resource://${packageName}/raw/your_video_file") // Replace with your video URI

        // Add space between the video player and the button grid
        Spacer(modifier = Modifier.height(16.dp))

        // Button grid
        Column(
            modifier = Modifier.fillMaxWidth(), // Make the inner column fill width for horizontal centering of rows
            horizontalAlignment = Alignment.CenterHorizontally // Center the rows horizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { Log.d("Button 1", "Button 1 clicked!") }) {
                    Text("Button 1")
                }
                Button(onClick = { Log.d("Button 2", "Button 2 clicked!") }) {
                    Text("Button 2")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { Log.d("Button 3", "Button 3 clicked!") }) {
                    Text("Button 3")
                }
                Button(onClick = { Log.d("Button 4", "Button 4 clicked!") }) {
                    Text("Button 4")
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        AppContent()
    }
}