package com.istudio.materialapp.modules.ui_selectioncomponents.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp


data class ToggleCheckBoxData (
    val isChecked : Boolean = false,
    val text : String = ""
)

@Composable
fun CheckBoxes() {
    // Create a collection of checkboxes as mutableState list in remember block
    val checkboxes = remember {
        mutableStateListOf(
            ToggleCheckBoxData( isChecked = false , text = "Type-1" ),
            ToggleCheckBoxData( isChecked = false , text = "Type-2" ),
            ToggleCheckBoxData( isChecked = false , text = "Type-3" )
        )
    }

    var triState by remember {
        // Indeterminate is the state when its either checked or unchecked
        mutableStateOf(ToggleableState.Indeterminate)
    }

    val toggleTriState = {
        triState = when(triState){
            ToggleableState.Indeterminate -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Off
            else -> ToggleableState.On
        }
        // If the triState is On when we updated triState - We will turn on all the checkbox to On
        checkboxes.indices.forEach { index ->
            checkboxes[index] = checkboxes[index].copy(
                isChecked = ( triState == ToggleableState.On )
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            toggleTriState()
        }.padding(end = 16.dp)
    ){
        TriStateCheckbox(state = triState, onClick = toggleTriState)
        Text(text = "All Types")
    }

    // Loop the checkboxes
    checkboxes.forEachIndexed{ index, info ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 32.dp)
                .clickable {
                checkboxes[index] = info.copy(
                    isChecked = !info.isChecked
                )
            }.padding(end = 16.dp)
        ){
            // Check box - item
            Checkbox(
                checked = info.isChecked,
                onCheckedChange = {newValue ->
                    // On check box selected - Update the index of collection
                    checkboxes[index] = info.copy(
                        isChecked = newValue
                    )
                }
            )
            // Check box - text
            Text(text = info.text)
        }
    }


}
