package com.plcoding.woox.presentation.splashscreen

import androidx.compose.animation.core.EaseInOutElastic
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.plcoding.woox.R
import com.plcoding.woox.common.moveOnNewScreen
import com.plcoding.woox.route.Screen
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navHostController: NavHostController
) {
    val context = LocalContext.current
    var scale by remember {
        mutableStateOf(0.dp)
    }
    val animateAble = animateDpAsState(
        targetValue = scale,
        animationSpec = tween(1000, 0, easing = EaseInOutElastic), label = ""
    )
    LaunchedEffect(key1 = true) {
        delay(3000L)
        navHostController.moveOnNewScreen(Screen.WelcomeScreen.route, true)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.t4s_logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(120.dp, 120.dp)
        )
    }
}