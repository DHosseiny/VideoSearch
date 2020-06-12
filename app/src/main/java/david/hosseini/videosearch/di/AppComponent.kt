package david.hosseini.videosearch.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, DispatcherModule::class])
interface AppComponent