package david.hosseini.videosearch.api

class CommentsResponse(val data: Array<CommentData>)

data class CommentData(val text: String, val user: User)