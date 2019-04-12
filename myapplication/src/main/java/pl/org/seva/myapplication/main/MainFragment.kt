package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.coroutineScope
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.inflate
import pl.org.seva.myapplication.main.extension.nav
import java.util.concurrent.TimeUnit

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fr_main, container)

    suspend fun f() = coroutineScope {

    }

    @SuppressLint("SetTextI18n", "CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val vm = ViewModelProviders.of(this, viewModelFactory<VM>())
                .get(VM::class.java)
        vm.identity()
        vm.bool = true

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .firstElement()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    println("wiktor go forward")
            nav(R.id.action_mainFragment_to_secondFragment)
        }

    }
}
