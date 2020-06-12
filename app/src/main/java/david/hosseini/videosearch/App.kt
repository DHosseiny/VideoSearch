package david.hosseini.videosearch

import android.app.Application
import david.hosseini.videosearch.di.AppComponent
import david.hosseini.videosearch.di.DaggerAppComponent

class App : Application() {

    companion object {

        lateinit var appComponent: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }

}