package com.plcoding.woox.presentation.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.plcoding.woox.R
import com.plcoding.woox.common.moveOnNewScreen
import com.plcoding.woox.route.Screen


@Composable
fun WelcomeScreen(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    navHostController.moveOnNewScreen(Screen.LoginScreen.route, true)
                },
            )
    }
}