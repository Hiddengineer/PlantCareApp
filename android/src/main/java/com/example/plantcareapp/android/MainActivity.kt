package com.example.plantcareapp.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plantcareapp.Greeting
import com.example.plantcareapp.android.MyApplicationTheme
import com.example.plantcareapp.android.ui.components.VideoPlayer // Assuming VideoPlayer is in this path

class MainActivity : ComponentActivity() {
    //overide the onCreate method and then set the content to the app content
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
    // Get the context
    val context = LocalContext.current

    // State variables to track button pressed state
    var button1Pressed by remember { mutableStateOf(false) }
    var button2Pressed by remember { mutableStateOf(false) }
    var button3Pressed by remember { mutableStateOf(false) }
    var button4Pressed by remember { mutableStateOf(false) }

    // Main content layout
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Video Player in the top half
        VideoPlayer(
            videoUri = "android.resource://${context.packageName}/raw/plant_video", // Updated URI
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
        )

        // The remaining space below the video player
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .padding(top = 200.dp)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(200.dp)
        ) {
            // Row 1 for the buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Button 1 and its circle
                ButtonWithIndicator(
                    buttonText = "Light",
                    isPressed = button1Pressed,
                    onButtonClick = { button1Pressed = !button1Pressed } // Toggle state on click
                )

                // Button 2 and its circle
                ButtonWithIndicator(
                    buttonText = "wateer",
                    isPressed = button2Pressed,
                    onButtonClick = { button2Pressed = !button2Pressed } // Toggle state on click
                )
            }

            // Row 2 for the buttons
            Row(
                modifier = Modifier.fillMaxWidth(), // Make the row fill the width for centered arrangement
                horizontalArrangement = Arrangement.SpaceEvenly // Distribute space evenly between buttons
            ) {
                // Button 3 and its circle
                ButtonWithIndicator(
                    buttonText = "Auto",
                    isPressed = button3Pressed,
                    onButtonClick = { button3Pressed = !button3Pressed } // Toggle state on click
                )

                // Button 4 and its circle
                ButtonWithIndicator(
                    buttonText = "Alarm",
                    isPressed = button4Pressed,
                    onButtonClick = { button4Pressed = !button4Pressed } // Toggle state on click
                )
            }
        }
    }
}

@Composable
// Button with Circle Indicator
fun ButtonWithIndicator(
    buttonText: String,
    isPressed: Boolean,
    onButtonClick: () -> Unit
) {
    // Box to hold the circle and the button
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp) // Space between circle and button
    ) {
        // Circle Indicator
        Box(
            modifier = Modifier
                .size(16.dp) // Size of the circle
                .background(
                    color = if (isPressed) Color.Green else Color.Red, // Color based on state
                    shape = CircleShape // Make it a circle
                )
        )

        // The Button
        Button(onClick = onButtonClick) {
            Text(buttonText)
        }
    }
}

@Composable
// Greeting View
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
// Preview function
fun DefaultPreview() {
    MyApplicationTheme {
        AppContent()
    }
}