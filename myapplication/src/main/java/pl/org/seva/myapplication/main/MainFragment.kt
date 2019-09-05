package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_main.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.nav

class MainFragment : Fragment(R.layout.fr_main) {

    @SuppressLint("CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        next { nav(R.id.action_mainFragment_to_secondFragment) }

        for (id in 1 until 10) {
            println("wiktor $id")
        }

        val to = 1
        for (id in 10 downTo to + 1) {
            println("wiktor misia $id")
        }

    }
}
