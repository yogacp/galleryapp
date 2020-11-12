package com.utsman.data.di

import com.utsman.data.repository.photo.PhotoRepositoryImpl
import com.utsman.data.repository.photo.PhotosRepository
import org.koin.core.scope.Scope
import org.koin.dsl.module

/**
 * Created by Yoga C. Pranata on 05/11/2020.
 * Android Engineer
 */
private fun Scope.providePhotoRepository(): PhotosRepository {
    return PhotoRepositoryImpl(get(), get())
}

val repositoryModule = module {
    single { providePhotoRepository() }
}