package app.isfaaghyth.imagedetail.di

import app.isfaaghyth.imagedetail.domain.ImageDetailUseCase
import app.isfaaghyth.imagedetail.viewmodel.ImageDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Yoga C. Pranata on 11/11/2020.
 * Android Engineer
 */
val imageDetailModule = module {
    single { ImageDetailUseCase(get()) }
    viewModel { ImageDetailViewModel(get()) }
}