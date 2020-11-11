package app.isfaaghyth.di.module

import com.utsman.abstraction.dispatcher.AppDispatcher
import com.utsman.abstraction.dispatcher.DispatcherProvider
import org.koin.dsl.module

/**
 * Created by Yoga C. Pranata on 11/11/2020.
 * Android Engineer
 */
val appModule = module {
    single<DispatcherProvider> { AppDispatcher() }
}