package com.plcoding.woox.route

import com.plcoding.woox.route.Graph.LOGIN
import com.plcoding.woox.route.Graph.SPLASH
import com.plcoding.woox.route.Graph.WELCOME

sealed class Screen(val route: String) {
    object SplashScreen : Screen(SPLASH)
    object LoginScreen : Screen(LOGIN)
    object WelcomeScreen : Screen(WELCOME)
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
}
