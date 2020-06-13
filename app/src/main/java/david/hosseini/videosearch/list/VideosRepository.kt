package david.hosseini.videosearch.list

import david.hosseini.videosearch.api.VideoRemoteDataSource
import david.hosseini.videosearch.api.model.Comment
import david.hosseini.videosearch.api.model.Video
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VideosRepository @Inject constructor(private val remoteDataSource: VideoRemoteDataSource,
                                           private val dispatcher: CoroutineDispatcher) {


    suspend fun searchVideos(keyword: String): List<Video> {
        return withContext(dispatcher) {
            runCatching {
                remoteDataSource.searchVideos(keyword)
            }.getOrDefault(emptyList())
        }
    }

    suspend fun getComments(videoId: String): List<Comment> {
        return withContext(dispatcher) {
            runCatching {
                remoteDataSource.getComments(videoId)
            }.getOrDefault(emptyList())
        }
    }
}