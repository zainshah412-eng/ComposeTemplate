package com.plcoding.woox.common

import androidx.navigation.NavController

fun NavController.moveOnNewScreen(id: String, isClear: Boolean = false) {
    navigate(id) {
        if (isClear) {
            popUpTo(this@moveOnNewScreen.currentDestination?.id!!) {
                inclusive = true
            }
        }
    }
}