package com.plcoding.woox.data.remote

import com.plcoding.woox.data.remote.dto.CoinDetailDto
import com.plcoding.woox.data.remote.dto.CoinDto
import com.plcoding.woox.domain.model.login.LoginResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ApiService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

    @GET
    suspend fun loginApi(
        @Url url: String,
    ): LoginResponse
}