package com.istudio.materialapp.modules.ui_bottomnavbar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ScreenHome() {
    CommonScreen(screenName = "Home", backgroundColor = Color.DarkGray)
}

@Composable
fun ScreenChat() {
    CommonScreen(screenName = "Chat", backgroundColor = Color.Magenta)
}

@Composable
fun ScreenSettings() {
    CommonScreen(screenName = "Settings", backgroundColor = Color.Cyan)
}


@Composable
private fun CommonScreen(screenName: String, backgroundColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace,
            style = TextStyle(
                color = Color.White
            ),
            text = screenName
        )
    }
}

@Preview
@Composable
private fun CurrentScreen() {
    ScreenHome()
}