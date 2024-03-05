package com.plcoding.woox.common.utils

import android.content.Context
import android.widget.Toast
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

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()