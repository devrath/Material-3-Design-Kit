package com.istudio.materialapp.modules.ui_components.ui_selectioncomponents.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


data class ToggleSwitchData(
    val isChecked : Boolean = true, val text : String = "Dark Mode"
)

@Composable
fun SwitchCustom() {

    var switchState by remember {
        mutableStateOf(ToggleSwitchData())
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = switchState.text)
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = switchState.isChecked,
            onCheckedChange = { isChecked ->
                switchState = if(isChecked){
                    switchState.copy(
                        isChecked = isChecked, text = "Dark Mode"
                    )
                }else{
                    switchState.copy(
                        isChecked = isChecked, text = "Light Mode"
                    )
                }
            }
        )
    }

}