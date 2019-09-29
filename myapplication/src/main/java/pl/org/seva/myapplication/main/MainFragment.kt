package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import pl.org.seva.myapplication.R

@ExperimentalCoroutinesApi
class MainFragment : Fragment(R.layout.fr_main) {

    private val ch = BroadcastChannel<Boolean>(Channel.CONFLATED)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(3000)
            ch.offer(true)
        }
    }

    override fun onResume() {
        super.onResume()

        lifecycleScope.launch {
            val ch = ch.openSubscription()
            println("wiktor waiting for")
            val received = ch.receive()
            println("wiktor received: $received")
            ch.cancel()
        }
        println("wiktor finished onResume")
    }
}
