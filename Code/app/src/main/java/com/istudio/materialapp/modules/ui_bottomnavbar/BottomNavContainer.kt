package com.istudio.materialapp.modules.ui_bottomnavbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ChatBubble
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

private data class BottomNavItem(
    val iconSelected: ImageVector,
    val iconUnSelected: ImageVector,
    val title: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomnavContent(modifier: Modifier = Modifier) {

    val navItems = remember {
        mutableStateListOf(
            BottomNavItem(
                title = "Home",
                iconSelected = Icons.Filled.Home, iconUnSelected = Icons.Outlined.Home,
            ),
            BottomNavItem(
                title = "Chat",
                iconSelected = Icons.Filled.ChatBubble, iconUnSelected = Icons.Outlined.ChatBubble,

                ),
            BottomNavItem(
                title = "Settings",
                iconSelected = Icons.Filled.Settings, iconUnSelected = Icons.Outlined.Settings,
            )
        )
    }

    // The state "rememberSaveable" helps to save the state in configuration changes, We can save in viewmodel also
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Scaffold(
            bottomBar = {
                NavigationBar {
                    navItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            // If both the index are same, return true indicating it is selected
                            selected = (selectedItemIndex == index),
                            onClick = {
                                selectedItemIndex = index
                            },
                            label = {
                                Text(text = item.title)
                            },
                            icon = {
                                Icon(
                                    imageVector = if (selectedItemIndex == index) {
                                        item.iconSelected
                                    } else {
                                        item.iconUnSelected
                                    },
                                    contentDescription = item.title
                                )
                            },
                        )
                    } 
                }
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(it)
            ) {

            }
        }

    }
}