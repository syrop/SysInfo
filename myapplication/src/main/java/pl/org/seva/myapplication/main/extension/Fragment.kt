package pl.org.seva.myapplication.main.extension

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat
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

fun Fragment.prefs(name: String): SharedPreferences =
        requireContext().getSharedPreferences(name, Context.MODE_PRIVATE)

fun Fragment.checkPermission(permission: String) =
        ContextCompat.checkSelfPermission(context!!, permission) == PackageManager.PERMISSION_GRANTED
