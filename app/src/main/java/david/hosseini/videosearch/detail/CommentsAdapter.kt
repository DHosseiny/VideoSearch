package david.hosseini.videosearch.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import david.hosseini.videosearch.R
import david.hosseini.videosearch.api.model.Comment

class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {

    val items = mutableListOf<Comment>()

    fun addItems(collection: Collection<Comment>) {
        items.addAll(collection)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_comment, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = items[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(comment: Comment) {
        }

    }
}