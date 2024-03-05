package com.plcoding.woox.presentation.coin_detail

import com.plcoding.woox.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
