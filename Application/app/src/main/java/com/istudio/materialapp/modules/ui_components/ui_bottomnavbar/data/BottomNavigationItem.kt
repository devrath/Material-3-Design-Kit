package com.istudio.materialapp.modules.ui_components.ui_bottomnavbar.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ChatBubble
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(
    val route:String,
    val iconSelected: ImageVector,
    val iconUnSelected: ImageVector,
    val title: String = ""
){
    // <--------- Home Screen --------->
    object Home : BottomNavigationItem(
        route = "home",
        title = "Home",
        iconSelected = Icons.Filled.Home,
        iconUnSelected = Icons.Outlined.Home,
    )
    // <--------- Chat Screen --------->
    object Chat : BottomNavigationItem(
        route = "chat",
        title = "Settings",
        iconSelected = Icons.Filled.ChatBubble,
        iconUnSelected = Icons.Outlined.ChatBubble,
    )
    // <--------- Settings Screen --------->
    object Settings : BottomNavigationItem(
        route = "settings",
        title = "Settings",
        iconSelected = Icons.Filled.Settings,
        iconUnSelected = Icons.Outlined.Settings,
    )
}
