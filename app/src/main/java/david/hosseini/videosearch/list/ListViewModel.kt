package david.hosseini.videosearch.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Singleton

class ListViewModel(private val repository: VideosRepository) : ViewModel()

@Singleton
class ListViewModelFactory @Inject constructor(private val repository: VideosRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        require(modelClass.isAssignableFrom(ListViewModel::class.java)) {
            "can't create instance of $modelClass"
        }

        @Suppress("UNCHECKED_CAST")
        return ListViewModel(repository) as T
    }
}