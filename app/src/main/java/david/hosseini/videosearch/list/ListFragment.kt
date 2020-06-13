package david.hosseini.videosearch.list

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import david.hosseini.videosearch.App.Companion.appComponent
import david.hosseini.videosearch.R
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : Fragment(R.layout.fragment_list) {

    @Inject lateinit var viewModelFactory: ListViewModelFactory

    private val viewModel: ListViewModel by viewModels(factoryProducer = { viewModelFactory })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent.injectListFragment(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configToolbar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        toolbar.setNavigationOnClickListener(null)
    }

    private fun configToolbar() {

        fun Toolbar.configureSearchMenu() {
            val searchView = menu.findItem(R.id.action_search).actionView as SearchView
            searchView.setOnQueryTextListener(viewModel.onQueryTextListener)
        }

        toolbar.apply {

            setNavigationIcon(R.drawable.ic_arrow_back)
            setNavigationOnClickListener { requireActivity().onBackPressed() }

            inflateMenu(R.menu.menu_search)
            configureSearchMenu()
        }
    }
}