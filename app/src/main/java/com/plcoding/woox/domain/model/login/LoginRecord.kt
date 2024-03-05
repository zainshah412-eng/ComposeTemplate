package com.plcoding.woox.domain.model.login

data class LoginRecord(
    val avatar: String,
    val branch_id: Int,
    val cellno: String,
    val create_dt: String,
    val email_address: String,
    val first_name: String,
    val gender: String,
    val has_paid: Int,
    val id: Int,
    val is_verified: Int,
    val last_name: String,
    val role_id: String,
    val school_id: Int,
    val ssid: String,
    val user_id: String,
    val uuid: Int,
    val web_pwd: String
)
