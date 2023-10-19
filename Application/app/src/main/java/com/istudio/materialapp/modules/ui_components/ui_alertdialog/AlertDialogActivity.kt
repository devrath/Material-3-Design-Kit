package com.istudio.materialapp.modules.ui_components.ui_alertdialog

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.istudio.materialapp.ui.theme.MaterialAppTheme

class AlertDialogActivity : ComponentActivity() {
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
    ) {

        var dialogDisplayState by remember { mutableStateOf(false) }

        if (dialogDisplayState) {
            normalDialog(dialogDisplayState) { newValue ->
                // Here we re-assign the boolean value and update the state
                dialogDisplayState = newValue
            }
        }


        Button(onClick = {
            dialogDisplayState = true
        }) {
            Text(text = "Display Dialog")
        }
    }
}

@Composable
private fun normalDialog(
    dialogDisplayState: Boolean,
    onDismiss: (Boolean) -> Unit
) {
    val contextForToast = LocalContext.current.applicationContext

    if (dialogDisplayState) {
        AlertDialog(
            onDismissRequest = {
                // Update the dialogDisplayState via Lambda when user clicks outside the dialog
                onDismiss(false)
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        // Update the dialogDisplayState via Lambda on click of action button
                        onDismiss(false)
                        Toast.makeText(contextForToast, "Yes", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        // Update the dialogDisplayState via Lambda on click of action button
                        onDismiss(false)
                        Toast.makeText(contextForToast, "No", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text(text = "No")
                }
            },
            title = { Text(text = "Are you sure?") },
            text = { Text(text = "Are you sure you want to perform a action") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Android,
                    contentDescription = "Action to be performed"
                )
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ScreenPreview() {
    MaterialAppTheme {
        ScreenContent()
    }
}