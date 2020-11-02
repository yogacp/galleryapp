package com.utsman.data.di

import app.isfaaghyth.network.Network
import com.utsman.data.ConstantValue
import com.utsman.data.repository.PhotoRepositoryImpl
import com.utsman.data.repository.PhotosRepository
import com.utsman.data.route.Services
import org.koin.core.scope.Scope
import org.koin.dsl.module


private fun Scope.provideRepository(): PhotosRepository {
    return PhotoRepositoryImpl(get())
}

private fun provideServices(): Services {
    return Network.builder(ConstantValue.BASE_URL).create(Services::class.java)
}

val repositoryModule = module {
    single { provideRepository() }
}

val serviceModule = module {
    single { provideServices() }
}