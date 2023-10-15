package com.istudio.materialapp.modules.ui_bottomnavbar.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.istudio.materialapp.modules.ui_bottomnavbar.data.BottomNavigationItem
import com.istudio.materialapp.modules.ui_bottomnavbar.screens.ScreenChat
import com.istudio.materialapp.modules.ui_bottomnavbar.screens.ScreenHome
import com.istudio.materialapp.modules.ui_bottomnavbar.screens.ScreenSettings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavContent(modifier: Modifier = Modifier) {

    // Data items to have the Bottom tabs
    val navItems = remember {
        mutableStateListOf(
            BottomNavigationItem.Home,
            BottomNavigationItem.Chat,
            BottomNavigationItem.Settings
        )
    }

    // The state "rememberSavable" helps to save the state in configuration changes, We can save in viewmodel also
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    // Keeping track of navigation
    val navController = rememberNavController();
    // Scaffold: it contains bottom navigation bar and a NavHost(Contains all screens) for each screen
    Scaffold(
        bottomBar = {
            NavigationBar {
                navItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        // If both the index are same, return true indicating it is selected
                        selected = (selectedItemIndex == index),
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.route)
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
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            BottomNavGraph(navController)
        }
    }
}

// Navigation graph: Contains all the screens as composable in a NavHost
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationItem.Home.route
    ) {
        composable(route = BottomNavigationItem.Home.route) {
            ScreenHome()
        }
        composable(route = BottomNavigationItem.Chat.route) {
            ScreenChat()
        }
        composable(route = BottomNavigationItem.Settings.route) {
            ScreenSettings()
        }
    }
}