package david.hosseini.videosearch

import android.app.Application
import david.hosseini.videosearch.di.AppComponent
import david.hosseini.videosearch.di.DaggerAppComponent

class App : Application() {

    companion object {

        val appComponent: AppComponent by lazy { DaggerAppComponent.create() }
    }

}