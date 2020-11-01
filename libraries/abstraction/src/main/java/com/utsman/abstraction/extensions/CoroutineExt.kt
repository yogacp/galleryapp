package com.utsman.abstraction.extensions

import com.utsman.abstraction.state.ResultState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

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
/*
suspend fun <T: Any> fetch(call: suspend () -> ResultState<T>) : ResultState<T> {
    return try {
        call.invoke()
    } catch (e: Throwable) {
        ResultState.Error(e)
    }
}*/

fun <T: Any>stateOf(): MutableStateFlow<ResultState<out T>> = run {
    MutableStateFlow(ResultState.Idle())
}

