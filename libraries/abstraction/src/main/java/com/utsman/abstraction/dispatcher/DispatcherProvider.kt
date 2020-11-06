package com.utsman.abstraction.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Yoga C. Pranata on 05/11/2020.
 * Android Engineer
 */
interface DispatcherProvider {
    fun main(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
}