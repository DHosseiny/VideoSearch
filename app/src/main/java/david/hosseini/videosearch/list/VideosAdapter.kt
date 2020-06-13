package david.hosseini.videosearch.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import david.hosseini.videosearch.R
import david.hosseini.videosearch.api.model.Video
import kotlinx.android.synthetic.main.item_video.view.*

class VideosAdapter : RecyclerView.Adapter<VideosAdapter.ViewHolder>() {

    private val items = mutableListOf<Video>()

    fun addItems(collection: Collection<Video>) {
        items.addAll(collection)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_video, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = items[position]
        holder.bind(video)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(video: Video) {
            itemView.textItemVideo.text = video.name
            showImage(video)
        }

        private fun showImage(video: Video) {

            Glide
                .with(itemView)
                .load(video.pictureLink)
                .into(itemView.imageItemVideo)
        }

    }
}