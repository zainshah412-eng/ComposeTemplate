package com.plcoding.woox.presentation.loginscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.woox.common.Constants
import com.plcoding.woox.common.Resource
import com.plcoding.woox.domain.use_case.get_coin.GetCoinUseCase
import com.plcoding.woox.domain.use_case.login.GetLoginUseCase
import com.plcoding.woox.presentation.coin_detail.CoinDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getLoginUseCase: GetLoginUseCase
) : ViewModel() {
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    init {
        getLogin()
    }

     fun getLogin() {
        getLoginUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = LoginState(loginResponse = result.data)
                }
                is Resource.Error -> {
                    _state.value = LoginState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = LoginState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}