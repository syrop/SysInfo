package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.plus

class MainFragment : Fragment(R.layout.fr_main) {

    inner class RxLiveData<T>(private val observable: Observable<T>) : LiveData<T>() {

        private lateinit var disposable: Disposable

        override fun onActive() {
            super.onActive()
            println("Wiktor state active: " + lifecycle.currentState)
            Thread.dumpStack()
            disposable = observable.subscribe { postValue(it) }
        }

        override fun onInactive() {
            super.onInactive()
            println("wiktor state inactive: ${lifecycle.currentState}")
            Thread.dumpStack()
            disposable.dispose()
        }
    }

    @SuppressLint("CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val obs = PublishSubject.create<Int>()

        val ld = RxLiveData(obs)

        (ld + this) { println("wiktor fajnie ")}

    }
}
