package pl.org.seva.myapplication.main

import android.graphics.Point
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import pl.org.seva.myapplication.R
import android.util.DisplayMetrics

@ExperimentalCoroutinesApi
class MainFragment : Fragment(R.layout.fr_main) {

    private val ch = BroadcastChannel<Boolean>(Channel.CONFLATED)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val display = requireActivity().windowManager.defaultDisplay
        val metrics = DisplayMetrics()
        display.getMetrics(metrics)
        val heightPixels: Int = metrics.heightPixels
        val widthPixels: Int = metrics.widthPixels
        val densityDpi: Int = metrics.densityDpi
        val xdpi: Float = metrics.xdpi
        val ydpi: Float = metrics.ydpi
        println("wiktor widthPixels  = $widthPixels")
        println("wiktor heightPixels = $heightPixels")
        println("wiktor densityDpi   = $densityDpi")
        println("wiktor xdpi         = $xdpi")
        println("wiktor ydpi         = $ydpi")
        val size = Point()
        display.getSize(size)
        println("wiktor screen width: ${size.x}")
        println("wiktor screen height: ${size.y}")
    }
}
