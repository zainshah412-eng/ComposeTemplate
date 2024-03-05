package com.plcoding.woox.ui.screens.bottomnav

import com.plcoding.woox.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
){
    object LeaderBoard: BottomBarScreen(
        route = "leaderboard",
        title = "Leader Board",
        icon = R.drawable.ic_records,
        icon_focused = R.drawable.ic_record_dark
    )

    // for result
    object Graph: BottomBarScreen(
        route = "graph",
        title = "Graph",
        icon = R.drawable.ic_results,
        icon_focused = R.drawable.ic_result_dark
    )


    // for profile
    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_profile,
        icon_focused = R.drawable.ic_profile_dark
    )
}
