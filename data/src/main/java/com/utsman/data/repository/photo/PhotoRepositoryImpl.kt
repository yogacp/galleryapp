package com.utsman.data.repository.photo

import com.utsman.abstraction.dispatcher.DispatcherProvider
import com.utsman.data.model.Photo
import com.utsman.data.route.NetworkServices
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.Response

class PhotoRepositoryImpl(
    private val services: NetworkServices,
    private val dispatcher: DispatcherProvider
) : PhotosRepository {

    override suspend fun getPhotos(page: Int): Response<List<Photo>> {
        return withContext(dispatcher.io()) {
            async { services.photos(page).await() }
        }.await()
    }

    override suspend fun getPhoto(imageId: String): Response<Photo> {
        return withContext(dispatcher.io()) {
            async { services.photo(imageId).await() }
        }.await()
    }

}