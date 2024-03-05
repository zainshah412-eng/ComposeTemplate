package com.plcoding.woox.domain.repository

import com.plcoding.woox.data.remote.dto.CoinDetailDto
import com.plcoding.woox.data.remote.dto.CoinDto
import com.plcoding.woox.domain.model.login.LoginResponse

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

    suspend fun getLogin(url:String): LoginResponse
}