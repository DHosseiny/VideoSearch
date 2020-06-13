package david.hosseini.videosearch.api.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Video(val id: Int,
                 val name: String,
                 val description: String,
                 val userName: String,
                 val pictureLink: String) : Parcelable