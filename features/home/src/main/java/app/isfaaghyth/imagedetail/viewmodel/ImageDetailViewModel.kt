package app.isfaaghyth.imagedetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.isfaaghyth.imagedetail.domain.ImageDetailUseCase
import kotlinx.coroutines.launch

/**
 * Created by Yoga C. Pranata on 11/11/2020.
 * Android Engineer
 */
class ImageDetailViewModel (private val useCase: ImageDetailUseCase) : ViewModel() {
    val photo = useCase.detailPhoto

    fun getPhoto(imageId: String) = viewModelScope.launch {
        useCase.getPhoto(this, imageId)
    }
}