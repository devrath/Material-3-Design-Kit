package com.istudio.materialapp.modules.ui_exposeddropdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.istudio.materialapp.ui.theme.MaterialAppTheme

class ExposedDropDownActivity : ComponentActivity() {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        var isExpanded by remember { mutableStateOf(false) }

        var actionText by remember { mutableStateOf("") }

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = {
                isExpanded = it
            }
        ) {
            TextField(
                value = actionText,
                onValueChange = { },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = isExpanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor(),
                placeholder = { Text(text = "Action") }
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Action - 1") },
                    onClick = {
                        actionText = "Action - 1"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "Action - 2") },
                    onClick = {
                        actionText = "Action - 2"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "Action - 3") },
                    onClick = {
                        actionText = "Action - 3"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "Action - 4") },
                    onClick = {
                        actionText = "Action - 4"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "Action - 5") },
                    onClick = {
                        actionText = "Action - 5"
                        isExpanded = false
                    }
                )

            }
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun ScreenPreview() {
    MaterialAppTheme {
        ScreenContent()
    }
}