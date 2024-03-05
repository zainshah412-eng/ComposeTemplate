package com.plcoding.woox.data.repository

import com.plcoding.woox.data.remote.CoinPaprikaApi
import com.plcoding.woox.data.remote.dto.CoinDetailDto
import com.plcoding.woox.data.remote.dto.CoinDto
import com.plcoding.woox.domain.model.login.LoginResponse
import com.plcoding.woox.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

    override suspend fun getLogin(): LoginResponse {
        return api.loginApi()
    }
}