package com.plcoding.woox.domain.use_case.login

import android.util.Log
import com.plcoding.woox.common.Resource
import com.plcoding.woox.domain.model.login.LoginRecord
import com.plcoding.woox.domain.model.login.LoginResponse
import com.plcoding.woox.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetLoginUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<LoginResponse>> = flow {
        try {
            emit(Resource.Loading<LoginResponse>())
            val coin = repository.getLogin()
            Log.d("DATA",coin.toString())
            emit(Resource.Success<LoginResponse>(coin))
        } catch(e: HttpException) {
            emit(Resource.Error<LoginResponse>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<LoginResponse>("Couldn't reach server. Check your internet connection."))
        }
    }

}