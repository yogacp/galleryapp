package app.isfaaghyth.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import app.isfaaghyth.home.domain.HomeUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: HomeUseCase) : ViewModel() {
    val photo = useCase.resultPhoto
        .asLiveData(viewModelScope.coroutineContext)

    fun getPhoto() = viewModelScope.launch {
        useCase.getPhoto(this)
    }
}