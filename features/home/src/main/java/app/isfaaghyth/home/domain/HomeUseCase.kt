package app.isfaaghyth.home.domain

import com.utsman.abstraction.extensions.fetch
import com.utsman.abstraction.extensions.stateOf
import com.utsman.data.model.Photo
import com.utsman.data.repository.PhotosRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeUseCase(private val repository: PhotosRepository) {
    val resultPhoto = stateOf<List<Photo>>()
    var page = 1

    suspend fun getPhoto(scope: CoroutineScope) = scope.launch {
        fetch {
            repository.getPhoto(page)
        }.collect {
            resultPhoto.value = it
        }
    }
}