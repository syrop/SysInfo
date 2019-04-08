package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.back
import pl.org.seva.myapplication.main.extension.inflate
import java.util.concurrent.TimeUnit

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fr_main, container)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val vm = ViewModelProviders.of(this, viewModelFactory<VM>())
                .get(VM::class.java)
        vm.identity()

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .firstElement()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    println("wiktor go back")
                    back()
                }
        println("wiktor bool ${vm.bool}")
    }
}
