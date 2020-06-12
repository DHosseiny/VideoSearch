package david.hosseini.videosearch.list

import androidx.lifecycle.*
import david.hosseini.videosearch.api.model.Video
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

class ListViewModel(private val repository: VideosRepository) : ViewModel() {


    private val _videos = MutableLiveData<List<Video>>()
    val videos: LiveData<List<Video>> = _videos

    fun searchKeyword(keyword: String) {

        if (keyword.length < 3) return //don't do search when user is typed few characters

        viewModelScope.launch {
            val videos = repository.searchVideos(keyword)
            _videos.value = videos
        }
    }
}

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