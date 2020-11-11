package com.utsman.data.repository.photo

import com.utsman.data.model.Photo
import retrofit2.Response

interface PhotosRepository {
    suspend fun getPhotos(page: Int): Response<List<Photo>>
}