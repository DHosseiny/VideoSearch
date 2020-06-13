package david.hosseini.videosearch.api

import david.hosseini.videosearch.api.model.Video
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject


class VideoRemoteDataSource @Inject constructor(private val vimeoApi: VimeoApi) {

    suspend fun searchVideos(keyword: String): List<Video> =
        vimeoApi.searchVideos(keyword).toVideos()

    private fun SearchResponse.toVideos(): List<Video> = data.map {
        //Here considered uri is always in this format : /videos/{id}
        val id = it.uri.substringAfterLast('/').toInt()
        //For brevity considered there is always a picture
        val pictureLink = it.pictures.pictures[0].link
        Video(id, it.name, pictureLink)
    }
}

interface VimeoApi {

    @GET("videos")
    suspend fun searchVideos(@Query("query") keyword: String): SearchResponse
}