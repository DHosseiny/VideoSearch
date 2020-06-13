package david.hosseini.videosearch.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import david.hosseini.videosearch.R
import david.hosseini.videosearch.api.model.Video
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(R.layout.fragment_detail) {

    companion object {
        fun newInstance(video: Video): DetailFragment {
            val fragment = DetailFragment()

            val bundle = Bundle()

            bundle.putParcelable(ARG_VIDEO, video)
            fragment.arguments = bundle

            return fragment
        }

        private const val ARG_VIDEO = "id"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        showVideoDetails()
    }

    private fun showVideoDetails() {
        val video = requireArguments().getParcelable<Video>(ARG_VIDEO)!!

        Glide.with(this)
            .load(video.pictureLink)
            .into(imageVideo)

        textTitle.text = video.name
        textDescription.text = video.description
        textSender.text = getString(R.string.sender, video.userName)
    }
}