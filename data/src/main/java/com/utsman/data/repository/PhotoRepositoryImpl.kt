package com.utsman.data.repository

import com.utsman.data.model.Photo
import com.utsman.data.route.Services

class PhotoRepositoryImpl(private val services: Services) : PhotosRepository {
    override suspend fun getPhoto(page: Int): List<Photo> {
        return services.photos(page)
    }
}