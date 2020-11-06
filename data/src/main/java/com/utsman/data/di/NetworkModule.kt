package com.utsman.data.di

import app.isfaaghyth.network.Network
import com.utsman.data.constant.RestConstant
import com.utsman.data.route.NetworkServices
import org.koin.dsl.module

private fun provideServices(): NetworkServices {
    return Network.builder(RestConstant.BASE_URL).create(NetworkServices::class.java)
}

val networkModule = module {
    single { provideServices() }
}