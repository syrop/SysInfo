package pl.org.seva.myapplication.main

import android.os.Bundle
import android.system.StructUtsname
import androidx.fragment.app.Fragment
import androidx.lifecycle.liveData
import kotlinx.coroutines.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.init.instance
import kotlin.coroutines.EmptyCoroutineContext
import pl.org.seva.myapplication.main.extension.observe

class MainFragment : Fragment(R.layout.fr_main) {

    private val unit = Unit

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val l = liveData<Int>(EmptyCoroutineContext + Dispatchers.IO) {
            try {
                while (true) {
                    println("wiktor fajnie")
                    delay(100)
                }
            }
            finally {
                println("wiktor jeszcze fajniej")
            }
        }

        GlobalScope.launch {
            println("wiktor wait one second")

            delay(1000)

            withContext(Dispatchers.Main) {
                l.observe(this@MainFragment) { }
            }

            println("wiktor wait one more second")

            delay(1000)

            withContext(Dispatchers.Main) {
                l.removeObservers(this@MainFragment)
            }
        }
    }
}
