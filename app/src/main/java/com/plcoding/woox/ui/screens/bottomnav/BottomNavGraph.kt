package com.plcoding.woox.ui.screens.bottomnav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.plcoding.woox.ui.screens.homescreen.HomeScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.LeaderBoard.route, modifier = modifier
    ) {
        composable(route = BottomBarScreen.LeaderBoard.route) {
            HomeScreen(navController)
        }
    }
}