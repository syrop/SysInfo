package pl.org.seva.myapplication.main

import androidx.lifecycle.ViewModel

class VM : ViewModel() {

    var bool = false

    fun identity() {

        println("wiktor ${System.identityHashCode(this)}")
    }

    override fun onCleared() {
        super.onCleared()
        println("wiktor cleared")
    }
}

