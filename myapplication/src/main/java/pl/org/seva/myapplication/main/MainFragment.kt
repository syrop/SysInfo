package pl.org.seva.myapplication.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import pl.org.seva.myapplication.R

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val ch1 = Channel<Int>()
        val ch2 = Channel<Int>()

        GlobalScope.launch {

        }
        GlobalScope.launch {
            for (a in 1..10) {
                ch1.send(a)
                ch2.send(a)
            }
        }
    }
}
