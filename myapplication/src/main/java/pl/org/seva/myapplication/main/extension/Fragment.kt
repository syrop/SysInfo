package pl.org.seva.myapplication.main.extension

import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController

fun Fragment.nav(@IdRes resId: Int): Boolean {
    findNavController().navigate(resId)
    return true
}

fun Fragment.back() = findNavController().popBackStack()

inline fun <reified R : ViewModel> Fragment.viewModel() = lazy { getViewModel<R>() }

inline fun <reified R : ViewModel> Fragment.getViewModel() = activity!!.getViewModel<R>()

fun Fragment.inflate(@LayoutRes resource: Int, root: ViewGroup?): View =
        layoutInflater.inflate(resource, root, false)
