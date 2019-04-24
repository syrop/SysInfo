package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.selects.select
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.inflate

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fr_main, container)

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
