package david.hosseini.videosearch.di

import dagger.Component
import david.hosseini.videosearch.list.ListFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, DispatcherModule::class])
interface AppComponent {

    fun injectListFragment(listFragment: ListFragment)
}