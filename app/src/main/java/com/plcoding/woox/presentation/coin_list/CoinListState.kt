package com.plcoding.woox.presentation.coin_list

import com.plcoding.woox.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
