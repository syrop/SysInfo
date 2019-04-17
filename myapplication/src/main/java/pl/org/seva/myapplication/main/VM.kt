package pl.org.seva.myapplication.main

import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class VM : ViewModel() {

    fun main() = Looper.getMainLooper().thread === Thread.currentThread()

    init {
        println("wiktor shall launch")
        viewModelScope.launch(Dispatchers.Default) {
            val dispatcher = coroutineContext[Dispatchers.Default.key]
            println("wiktor dispatcher $dispatcher")
            println("wiktor in the launch ${main()}")
            val d = CompletableDeferred<Unit>()
            launch { throw Exception("wiktor exception") }
            delay(1000)
            println("wiktor delayed")
        }
    }
}
