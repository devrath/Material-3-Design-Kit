package com.istudio.materialapp.modules.ui_components.ui_buttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.istudio.materialapp.ui.theme.MaterialAppTheme

class ButtonsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenContent()
                }
            }
        }
    }
}

@Composable
fun ScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        // Normal Button - Used to indicate a major action on screen like confirm action.
        Button( onClick = { /** Your action **/ }) {
            Text(text = "Action")
        }
        // Button with a shadow - Usually used if buttons are on top of a image since it has a background.
        ElevatedButton(onClick = { /** Your action **/ }) {
            Text(text = "Action")
        }
        // Button with light toned color - Usually used if we need lot of buttons on screen for a scenario like button per row in a list
        FilledTonalButton(onClick = { /** Your action **/ }) {
            Text(text = "Action")
        }
        // Button with light toned background but still with a border 
        OutlinedButton(onClick = { /** Your action **/ }) {
            Text(text = "Action")
        }
        // Button with least prominence - It looks like a text but action has a button action
        TextButton(onClick = { /** Your action **/ }) {
            Text(text = "Action")
        }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialAppTheme {
        ScreenContent()
    }
}