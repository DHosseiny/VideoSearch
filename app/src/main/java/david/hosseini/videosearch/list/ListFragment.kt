package david.hosseini.videosearch.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import david.hosseini.videosearch.App.Companion.appComponent
import david.hosseini.videosearch.R
import javax.inject.Inject

class ListFragment : Fragment(R.layout.fragment_list) {

    @Inject lateinit var viewModelFactory: ListViewModelFactory

    private val viewModel: ListViewModel by viewModels(factoryProducer = { viewModelFactory })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent.injectListFragment(this)
    }
}