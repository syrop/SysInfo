package pl.org.seva.myapplication.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import pl.org.seva.myapplication.R

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val ch1 = Channel<Int>()
        val ch2 = Channel<Int>()
        val br1 = BroadcastChannel<Int>(Channel.CONFLATED)
        br1.openSubscription()
        ch1.close()

        GlobalScope.launch {

            coroutineScope {
                val i = launch {
                    try {
                        println("wiktor 0")
                        delay(500)
                        println("wiktor a")
                    }
                    finally {
                        println("wiktor b")
                    }
                }
                i.cancel()
            }

        }
        GlobalScope.launch {
            for (a in 1..10) {
                ch1.send(a)
                ch2.send(a)
            }
        }
    }
}
