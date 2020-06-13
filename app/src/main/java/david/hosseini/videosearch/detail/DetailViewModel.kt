package david.hosseini.videosearch.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import david.hosseini.videosearch.api.model.Comment
import david.hosseini.videosearch.list.VideosRepository

class DetailViewModel(private val videoId: String, private val repository: VideosRepository) :
    ViewModel() {

    val comments: LiveData<List<Comment>> = liveData {
        emit(repository.getComments(videoId))
    }

}

class DetailViewModelFactory(private val videoId: String,
                             private val repository: VideosRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        require(modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            "can't create instance of $modelClass"
        }

        @Suppress("UNCHECKED_CAST")
        return DetailViewModel(videoId, repository) as T
    }
}