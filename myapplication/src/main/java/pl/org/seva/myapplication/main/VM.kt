package pl.org.seva.myapplication.main

import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class VM : ViewModel() {

    val ld = MutableLiveData<Int>()

    private fun main() = Looper.getMainLooper().thread === Thread.currentThread()

    private fun thread() = "${System.identityHashCode(Thread.currentThread())}"

    private suspend fun f2() = coroutineScope {
        println("wiktor wewnętrzny thread ${thread()} ${main()}")
    }

    fun identity() {
        viewModelScope.launch {
            coroutineScope {
                println("wiktor mój thread ${thread()} ${main()}")
                f2()
                withContext(Dispatchers.IO) {
                    println("wiktor nie mój thread ${thread()} ${main()}")
                    f2()
                    delay(4000)
                }
                println("wiktor mój thread ${thread()} ${main()}")
                ld.value = 10
            }
        }

        println("wiktor canceled")
    }

    override fun onCleared() {
        super.onCleared()
        println("wiktor cleared")
    }
}
