package com.plcoding.woox.ui.screens.bottomnav

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.plcoding.woox.common.theme.ColorPrimary
import com.plcoding.woox.common.theme.CreamColor
import com.plcoding.woox.common.theme.fonts
import com.plcoding.woox.common.theme.updateStatusBarColor

var showBottomTabs = true

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav() {
    val navController = rememberNavController()
    updateStatusBarColor(Color.White, true)
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { contentPadding ->
        BottomNavGraph(
            navController = navController,
            modifier = Modifier.padding(contentPadding)
        )
    }
}

fun setShowBottomTabVariable(myValue: Boolean) {
    showBottomTabs = myValue
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.LeaderBoard,
        BottomBarScreen.Graph,
        BottomBarScreen.Profile
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
//    val showBottomTabs by remember { mutableStateOf(false) }
    if (showBottomTabs) {
        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 8.dp, bottom = 15.dp)
                .background(
                    CreamColor,
                    shape = RoundedCornerShape(35.dp)
                )
                .fillMaxWidth()
                .padding(horizontal = 10.dp)

                .height(70.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    //val selected = (currentDestination?.id ?: false) == screen.route

    val background =
        if (selected) ColorPrimary else Color.Transparent

    val contentColor = Color.Black
    //if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier

            .height(50.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }), contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        ) {

            Icon(
                painter = painterResource(id = if (selected) screen.icon_focused else screen.icon),
                contentDescription = "icon",

                )

            AnimatedVisibility(visible = selected) {
                Text(
                    text = screen.title,
                    color = contentColor,
                    textAlign = TextAlign.Center,
                    fontFamily = fonts
                )
            }
        }
    }
}

@Composable
@Preview
fun BottomNavPreview() {
    val navController = rememberNavController()
    BottomBar(navController)
}