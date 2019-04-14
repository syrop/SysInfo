package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.Single
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.rx2.await
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.getViewModel
import pl.org.seva.myapplication.main.extension.inflate
import pl.org.seva.myapplication.main.extension.observe

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fr_main, container)

    @SuppressLint("SetTextI18n", "CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        GlobalScope.launch {
            val sin = Single.fromCallable { 10 }
            sin.await()
        }


        val vm = getViewModel<VM>()
        vm.ld.observe(this) { println("wiktor $it")}
        vm.identity()
    }
}
