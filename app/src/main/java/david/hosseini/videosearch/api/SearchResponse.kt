package david.hosseini.videosearch.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SearchResponse(val data: Array<Data>)

@JsonClass(generateAdapter = true)
data class Data(val uri: String, val name: String, val pictures: Pictures)

@JsonClass(generateAdapter = true)
class Pictures(val sizes: Array<Size>)

@JsonClass(generateAdapter = true)
data class Size(val link: String)