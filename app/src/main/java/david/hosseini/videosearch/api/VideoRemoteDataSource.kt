package david.hosseini.videosearch.api

import retrofit2.http.GET
import retrofit2.http.Query

interface VimeoApi {

    @GET("videos")
    suspend fun searchVideos(@Query("query") keyword: String): SearchResponse
}