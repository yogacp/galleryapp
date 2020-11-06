package com.utsman.data.repository.photo

import com.utsman.data.model.Photo
import com.utsman.data.route.NetworkServices

class PhotoRepositoryImpl(private val services: NetworkServices) : PhotosRepository {
    override suspend fun getPhoto(page: Int): List<Photo> {
        return services.photos(page)
    }
}