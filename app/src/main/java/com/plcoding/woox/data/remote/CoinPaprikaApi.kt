package com.plcoding.woox.data.remote

import com.plcoding.woox.common.Constants.USER_AUTHENTICATE
import com.plcoding.woox.data.remote.dto.CoinDetailDto
import com.plcoding.woox.data.remote.dto.CoinDto
import com.plcoding.woox.domain.model.login.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

    @GET(USER_AUTHENTICATE)
    suspend fun loginApi(): LoginResponse
}