package app.isfaaghyth.starter

import android.app.Application
import app.isfaaghyth.di.components.appComponents
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appComponents)
        }
    }
}