package com.istudio.materialapp.modules.ui_components.ui_bottomnavbar.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.istudio.materialapp.modules.ui_components.ui_bottomnavbar.content.BottomNavContent
import com.istudio.materialapp.ui.theme.MaterialAppTheme

class BottomNavigationBarActivity : ComponentActivity() {
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
    BottomNavContent()
}

@Preview(showBackground = true)
@Composable
fun CurrentScreenPreview() {
    MaterialAppTheme {
        ScreenContent()
    }
}