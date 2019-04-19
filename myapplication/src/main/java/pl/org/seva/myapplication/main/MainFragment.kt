package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.android.synthetic.main.fr_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.rx2.await
import kotlinx.coroutines.rx2.rxCompletable
import kotlinx.coroutines.sync.Mutex
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.getViewModel
import pl.org.seva.myapplication.main.extension.inflate
import pl.org.seva.myapplication.main.extension.observe
import pl.org.seva.myapplication.main.extension.viewModel
import java.lang.Exception
import java.util.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fr_main, container)

    private val vm by lazy { ViewModelProviders.of(this).get(VM::class.java) }



    @SuppressLint("SetTextI18n", "CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("wiktor $vm")

    }

    override fun onDestroy() {
        super.onDestroy()
        println("wiktor destroy fragment")
    }
}

