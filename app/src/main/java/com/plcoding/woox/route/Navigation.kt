package com.plcoding.woox.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.plcoding.woox.presentation.coin_detail.CoinDetailScreen
import com.plcoding.woox.presentation.coin_list.CoinListScreen
import com.plcoding.woox.presentation.loginscreen.LoginScreen
import com.plcoding.woox.presentation.splashscreen.SplashScreen
import com.plcoding.woox.presentation.welcomescreen.WelcomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(
            route = Screen.SplashScreen.route
        ) {
            SplashScreen(navController)
        }
        composable(
            route = Screen.WelcomeScreen.route
        ) {
            WelcomeScreen(navController)
        }
        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(navController)
        }
        composable(
            route = Screen.CoinListScreen.route
        ) {
            CoinListScreen(navController)
        }
        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            CoinDetailScreen()
        }
    }
}