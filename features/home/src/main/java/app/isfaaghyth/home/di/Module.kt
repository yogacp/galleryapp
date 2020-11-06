package app.isfaaghyth.home.di

import app.isfaaghyth.home.domain.HomeUseCase
import app.isfaaghyth.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModule = module {
    single { HomeUseCase(get()) }
    viewModel { HomeViewModel(get()) }
}