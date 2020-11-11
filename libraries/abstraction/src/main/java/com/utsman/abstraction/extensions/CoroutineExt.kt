package com.utsman.abstraction.extensions

import androidx.lifecycle.MutableLiveData
import com.utsman.abstraction.state.ResultState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

/**
 * With flow
 * */
suspend fun <T: Any> fetch(call: suspend () -> T): Flow<ResultState<out T>> = flow {
    emit(ResultState.Loading())
    try {
        val data = call.invoke()
        emit(ResultState.Success(data))
    } catch (e: Throwable) {
        emit(ResultState.Error<T>(th = e))
    }
}


/**
 * Without flow
 * */
suspend fun <T: Any> fetchData(call: suspend () -> Response<T>) : ResultState<T> {
    ResultState.Loading<T>()
    return try {
        if(call.invoke().isSuccessful && call.invoke().body() != null) {
            ResultState.Success(call.invoke().body() as T)
        } else {
            ResultState.Message("Error fetching data: ${call.invoke().message()}")
        }
    } catch (e: Throwable) {
        ResultState.Error(e)
    }
}

fun <T: Any>stateOf(): MutableStateFlow<ResultState<out T>> = run {
    MutableStateFlow(ResultState.Idle())
}

fun <T: Any>liveDataOf(): MutableLiveData<ResultState<out T>> = run {
    MutableLiveData(ResultState.Idle())
}

