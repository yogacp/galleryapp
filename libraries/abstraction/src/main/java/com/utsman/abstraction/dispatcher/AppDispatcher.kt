package com.utsman.abstraction.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by Yoga C. Pranata on 05/11/2020.
 * Android Engineer
 */
class AppDispatcher : DispatcherProvider {
    override fun main(): CoroutineDispatcher = Dispatchers.Main
    override fun default(): CoroutineDispatcher = Dispatchers.Default
    override fun io(): CoroutineDispatcher = Dispatchers.IO
}