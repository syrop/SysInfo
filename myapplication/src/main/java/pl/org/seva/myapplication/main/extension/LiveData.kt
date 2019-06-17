package pl.org.seva.myapplication.main.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

operator fun <T> LiveData<T>.invoke(owner: LifecycleOwner, observer: (T) -> Unit) =
        observe(owner) { observer(it) }

@Suppress("unused")
fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T) -> Unit) =
        observe(owner, Observer<T> { observer(it) })
