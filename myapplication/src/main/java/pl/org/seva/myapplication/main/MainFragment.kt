package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import pl.org.seva.myapplication.R
import java.util.concurrent.CancellationException

@ExperimentalCoroutinesApi
class MainFragment : Fragment(R.layout.fr_main) {

    private val ch = BroadcastChannel<Boolean>(Channel.CONFLATED)

    private suspend fun s() = suspendCancellableCoroutine<Unit> {
        it.cancel()
        println("wiktor after cancel")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            try {
                s()
                println("wiktor no exception")
            } catch (e: CancellationException) {
                println("wiktor exception")
            }
        }
    }
}
