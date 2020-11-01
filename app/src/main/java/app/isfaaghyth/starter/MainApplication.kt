package app.isfaaghyth.starter

import android.app.Application
import app.isfaaghyth.home.di.homeUseCaseModule
import app.isfaaghyth.home.di.homeViewModelModule
import com.utsman.data.di.repositoryModule
import com.utsman.data.di.serviceModule
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                // data
                serviceModule,
                repositoryModule,

                // home
                homeUseCaseModule,
                homeViewModelModule
            )
        }
    }
}