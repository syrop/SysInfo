package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.*
import kotlinx.coroutines.rx2.await
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.inflate
import java.util.concurrent.TimeUnit

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fr_main, container)

    private val vm by lazy { ViewModelProviders.of(this).get(VM::class.java) }

    private suspend fun f(a: Int) = suspendCancellableCoroutine<Int> { continuation ->
        println("wiktor waiting for $a")
        Observable.timer(10,TimeUnit.SECONDS)
                .take(1)
                .subscribe { continuation.resumeWith(Result.success(a)) }
        println("wiktor waited for $a")


        GlobalScope.launch { Dispatchers.Main }
    }

    private suspend fun fancy() = coroutineScope {
        val a = async { f(10) }
        val b = async { f(20) }
        return@coroutineScope 10
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        GlobalScope.launch {
            println("wiktor plus ${fancy()}")
        }
    }
}
