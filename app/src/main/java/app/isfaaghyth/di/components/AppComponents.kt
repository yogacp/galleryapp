package app.isfaaghyth.di.components

import app.isfaaghyth.di.module.appModule
import app.isfaaghyth.home.di.homeViewModelModule
import app.isfaaghyth.imagedetail.di.imageDetailModule
import com.utsman.data.di.repositoryModule
import com.utsman.data.di.networkModule
import org.koin.core.module.Module

/**
 * Created by Yoga C. Pranata on 05/11/2020.
 * Android Engineer
 */
val appComponents: List<Module> = listOf(
    /**
     * Abstraction
     */
    appModule,


    /**
     * Data Module
     */
    networkModule,
    repositoryModule,


    /**
     * Feature Module
     */
    homeViewModelModule,
    imageDetailModule
)