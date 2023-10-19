package com.istudio.materialapp.modules.ui_components.ui_selectioncomponents.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


data class RadioButtonData(
    val isSelected: Boolean = false, val text: String = ""
)

@Composable
fun RadioButtonCustom() {

    val radioButtonStates = remember {
        mutableStateListOf(
            RadioButtonData(isSelected = true, text = "Type-1"),
            RadioButtonData(isSelected = false, text = "Type-2"),
            RadioButtonData(isSelected = false, text = "Type-3")
        )
    }

    radioButtonStates.forEachIndexed { index, info ->

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentWidth()
                .clickable {
                    radioButtonStates.replaceAll {
                        it.copy(
                            isSelected = it.text == info.text
                        )
                    }
                }
                .padding(end = 16.dp)
        ) {
            RadioButton(
                selected = info.isSelected,
                onClick = {
                    radioButtonStates.replaceAll {
                        it.copy(
                            isSelected = it.text == info.text
                        )
                    }
                }
            )
            Text(text = info.text)
        }
    }
}