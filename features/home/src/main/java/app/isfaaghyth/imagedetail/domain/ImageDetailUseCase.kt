package app.isfaaghyth.imagedetail.domain

import com.utsman.abstraction.extensions.fetchData
import com.utsman.abstraction.extensions.liveDataOf
import com.utsman.data.model.Photo
import com.utsman.data.repository.photo.PhotosRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by Yoga C. Pranata on 11/11/2020.
 * Android Engineer
 */
class ImageDetailUseCase (private val repository: PhotosRepository) {
    val detailPhoto = liveDataOf<Photo>()

    suspend fun getPhoto(scope: CoroutineScope, imageId: String) = scope.launch {
        val data = fetchData { repository.getPhoto(imageId) }
        detailPhoto.postValue(data)
    }
}