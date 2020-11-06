package app.isfaaghyth.di.components

import app.isfaaghyth.home.di.homeViewModelModule
import com.utsman.data.di.repositoryModule
import com.utsman.data.di.networkModule
import org.koin.core.module.Module

/**
 * Created by Yoga C. Pranata on 05/11/2020.
 * Android Engineer
 */
val appComponents: List<Module> = listOf(
    /**
     * Data Module
     */
    networkModule,
    repositoryModule,


    /**
     * Feature Module
     */
    homeViewModelModule
)