package com.plcoding.woox.domain.model.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val records: List<LoginRecord>
)