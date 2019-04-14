package pl.org.seva.myapplication.main

import android.os.Looper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VM : ViewModel() {

    private fun main() = Looper.getMainLooper().thread === Thread.currentThread()

    fun identity() {
        viewModelScope.launch {
            println("wiktor mój thread ${Looper.getMainLooper().thread} ${main()}")
            withContext (Dispatchers.IO) {
                println("wiktor nie mój thread ${Looper.getMainLooper().thread} ${main()}")
                delay(5000)
            }
            println("wiktor mój thread ${Looper.getMainLooper().thread} ${main()}")
        }
    }

    override fun onCleared() {
        super.onCleared()
        println("wiktor cleared")
    }
}
