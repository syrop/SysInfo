package pl.org.seva.myapplication.main

import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel

class VM : ViewModel() {

    fun main() = Looper.getMainLooper().thread === Thread.currentThread()

    override fun onCleared() {
        super.onCleared()
        println("wiktor on cleared")
    }
}
