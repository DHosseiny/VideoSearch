package david.hosseini.videosearch.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner,
                                   crossinline function: (T) -> Unit) {

    observe(lifecycleOwner, Observer { function(it) })
}