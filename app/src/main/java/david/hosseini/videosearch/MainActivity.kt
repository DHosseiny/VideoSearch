package david.hosseini.videosearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import david.hosseini.videosearch.list.ListFragment
import kotlinx.android.synthetic.main.activity_list.*

class MainActivity : AppCompatActivity(R.layout.activity_list) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (fragmentList == null) {
            supportFragmentManager.commit {
                add(R.id.frameContainer, ListFragment())
            }
        }
    }
}