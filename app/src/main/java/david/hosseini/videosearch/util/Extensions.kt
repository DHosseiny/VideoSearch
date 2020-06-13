package david.hosseini.videosearch.util

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner,
                                   crossinline function: (T) -> Unit) {

    observe(lifecycleOwner, Observer { function(it) })
}


fun View.hideKeyboard() {
    val inputMethodManager = getSystemService(context, InputMethodManager::class.java)!!
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}