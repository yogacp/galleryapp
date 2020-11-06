package com.utsman.abstraction.extensions

import com.utsman.abstraction.BuildConfig

/**
 * Created by Yoga C. Pranata on 05/11/2020.
 * Android Engineer
 */
fun debugMode(function: () -> Unit) {
    if (BuildConfig.DEBUG) {
        function()
    }
}

inline fun <T : Any> T?.notNull(f: (it: T) -> Unit) {
    if (this != null) f(this)
}

inline fun String?.notNullOrEmpty(f: (it: String) -> Unit): String? {
    return if (this != null && this.trim().isNotEmpty()) {
        f(this)
        this
    } else null
}