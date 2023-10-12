package com.istudio.materialapp.modules.ui_swipabletabrows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.istudio.materialapp.modules.ui_selectioncomponents.widgets.CheckBoxes
import com.istudio.materialapp.modules.ui_selectioncomponents.widgets.RadioButtonCustom
import com.istudio.materialapp.modules.ui_selectioncomponents.widgets.SwitchCustom
import com.istudio.materialapp.ui.theme.MaterialAppTheme

class SwipableTabRowsActivity : ComponentActivity() {
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
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TabContent()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MaterialAppTheme {
        ScreenContent()
    }
}


