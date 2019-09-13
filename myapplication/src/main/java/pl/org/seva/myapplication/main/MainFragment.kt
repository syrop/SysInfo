package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fr_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.nav

class MainFragment : Fragment(R.layout.fr_main) {

    @SuppressLint("CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        next { nav(R.id.action_mainFragment_to_secondFragment) }

        val wiktorLiveData = object : LiveData<Unit>() {
            override fun onActive() {
                println("wiktor active")
            }

            override fun onInactive() {
                println("wiktor inactive")

            }
        }

        fun <T> LiveData<T>.reObserve(owner: LifecycleOwner, observer: Observer<T>) {
            println("wiktor ${System.identityHashCode(observer)}")
            removeObserver(observer)
            observe(owner, observer)
        }

        fun zaba() {
            wiktorLiveData.reObserve(this, Observer { "aa" })
        }

        zaba()
        zaba()
    }
}
