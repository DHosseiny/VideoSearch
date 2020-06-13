package david.hosseini.videosearch.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import david.hosseini.videosearch.api.model.Video

class DetailFragment : Fragment() {

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
}