package com.plcoding.woox.ui.screens.loginscreen

import com.plcoding.woox.domain.model.login.LoginResponse

data class LoginState(
    val isLoading: Boolean = false,
    val loginResponse: LoginResponse? = null,
    val error: String = ""
)