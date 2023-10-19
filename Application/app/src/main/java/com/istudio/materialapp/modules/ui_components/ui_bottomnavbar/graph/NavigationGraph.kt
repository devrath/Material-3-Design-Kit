package com.istudio.materialapp.modules.ui_components.ui_bottomnavbar.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.istudio.materialapp.modules.ui_components.ui_bottomnavbar.data.BottomNavigationItem
import com.istudio.materialapp.modules.ui_components.ui_bottomnavbar.screens.ScreenChat
import com.istudio.materialapp.modules.ui_components.ui_bottomnavbar.screens.ScreenHome
import com.istudio.materialapp.modules.ui_components.ui_bottomnavbar.screens.ScreenSettings

// Navigation graph: Contains all the screens as composable in a NavHost
@Composable
fun NavigationGraph(navController: NavHostController) {
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