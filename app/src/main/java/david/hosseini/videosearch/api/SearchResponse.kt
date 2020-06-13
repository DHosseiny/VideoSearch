package david.hosseini.videosearch.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SearchResponse(val data: Array<Data>)

@JsonClass(generateAdapter = true)
data class Data(val uri: String,
                val name: String,
                val description: String,
                val user: User,
                val pictures: Pictures)

@JsonClass(generateAdapter = true)
data class User(val name: String)

@JsonClass(generateAdapter = true)
class Pictures(@Json(name = "sizes") val pictures: Array<Picture>)

@JsonClass(generateAdapter = true)
data class Picture(val link: String)