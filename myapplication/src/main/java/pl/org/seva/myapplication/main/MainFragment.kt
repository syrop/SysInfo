package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import kotlinx.android.synthetic.main.fr_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.nav

class MainFragment : Fragment(R.layout.fr_main) {


    interface I {
        @JvmSynthetic
        suspend fun a() = 1
    }

    class C : I
    private val vm by navGraphViewModels<VM>(R.id.nav_graph)

    @SuppressLint("CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        next { nav(R.id.action_mainFragment_to_secondFragment) }

        val a = C()
        GlobalScope.launch {
            println("wiktor ${a.a()}")
        }

    }
}
