package app.isfaaghyth.home.domain

import com.utsman.abstraction.extensions.fetchData
import com.utsman.abstraction.extensions.liveDataOf
import com.utsman.data.model.Photo
import com.utsman.data.repository.photo.PhotosRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeUseCase(private val repository: PhotosRepository) {
    val resultPhoto = liveDataOf<List<Photo>>()
    var page = 1

    suspend fun getPhoto(scope: CoroutineScope) = scope.launch {
        val data = fetchData { repository.getPhotos(page) }
        resultPhoto.postValue(data)
    }
}