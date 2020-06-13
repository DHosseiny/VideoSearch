package david.hosseini.videosearch.api

import david.hosseini.videosearch.api.model.Comment
import david.hosseini.videosearch.api.model.Video
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject


class VideoRemoteDataSource @Inject constructor(private val vimeoApi: VimeoApi) {

    suspend fun searchVideos(keyword: String): List<Video> =
        vimeoApi.searchVideos(keyword).toVideos()

    suspend fun getComments(videoId: String): List<Comment> =
        vimeoApi.getComments(videoId).toComments()

    private fun SearchResponse.toVideos(): List<Video> = data.map {
        //Here considered uri is always in this format : /videos/{id}
        val id = it.uri.substringAfterLast('/').toInt()
        val username = it.user.name
        //For brevity considered there is always a picture
        val pictureLink = it.pictures.pictures[0].link
        Video(id, it.name, it.description, username, pictureLink)
    }

    private fun CommentsResponse.toComments(): List<Comment> = data.map {

        val username = it.user.name
        Comment(it.text, username)
    }
}

interface VimeoApi {

    @GET("videos")
    suspend fun searchVideos(@Query("query") keyword: String): SearchResponse

    @GET("videos/{video_id}/comments")
    suspend fun getComments(@Path(value = "video_id", encoded = true) videoId: String)
            : CommentsResponse
}