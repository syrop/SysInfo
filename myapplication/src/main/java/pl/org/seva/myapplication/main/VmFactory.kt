package pl.org.seva.myapplication.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified R : ViewModel> viewModelFactory() = object : ViewModelProvider.Factory {

    val result by instance<R>()

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return result as T
    }
}
