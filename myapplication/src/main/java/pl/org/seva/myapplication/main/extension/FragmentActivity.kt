package pl.org.seva.myapplication.main.extension

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified R : ViewModel> FragmentActivity.viewModel() = lazy { getViewModel<R>() }

inline fun <reified R : ViewModel> FragmentActivity.getViewModel() =
        ViewModelProvider(this).get(R::class.java)
