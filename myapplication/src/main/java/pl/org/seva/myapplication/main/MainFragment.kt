package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.addCallback
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

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Handle the back button event
            println("wiktor back main")
        }
    }
}
