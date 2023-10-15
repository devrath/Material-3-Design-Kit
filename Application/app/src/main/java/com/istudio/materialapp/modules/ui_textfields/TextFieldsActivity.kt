package com.istudio.materialapp.modules.ui_textfields

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.istudio.materialapp.ui.theme.MaterialAppTheme

class TextFieldsActivity : ComponentActivity() {
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


        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            var valueState by remember { mutableStateOf("") }

            TextField(
                // Setting current value - Which is displayed
                value = valueState,
                // Updating new value to the displayed text
                onValueChange = { updatedText ->
                    if(updatedText.isDigitsOnly()){
                        // Set only if they are digits
                        valueState = updatedText
                    }
                },
                // Always use copy to modify a particular attribute
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Left
                ),
                label = {
                    Text(text = "Enter your height")
                },
                placeholder = {
                    Text(text = "Height")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Height,
                        contentDescription = "Person Height"
                    )
                },
                // It is the text that appears before the TEXT that user enters
                suffix = {
                    Text(text = "FEET")
                },
                // Number only
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                supportingText = {
                    Text(text = "Required Field")
                },
                isError = true
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        var valueStateTwo by remember { mutableStateOf("") }

        OutlinedTextField(
            // Setting current value - Which is displayed
            value = valueStateTwo,
            // Updating new value to the displayed text
            onValueChange = { updatedText ->
                if(updatedText.isDigitsOnly()){
                    // Set only if they are digits
                    valueStateTwo = updatedText
                }
            },
            // Always use copy to modify a particular attribute
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Left
            ),
            label = {
                Text(text = "Enter your height")
            },
            placeholder = {
                Text(text = "Height")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Height,
                    contentDescription = "Person Height"
                )
            },
            // It is the text that appears before the TEXT that user enters
            suffix = {
                Text(text = "FEET")
            },
            // Number only
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            supportingText = {
                Text(text = "Required Field")
            },
        )
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialAppTheme {
        ScreenContent()
    }
}