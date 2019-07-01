package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import kotlinx.android.synthetic.main.fr_main.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.nav

class MainFragment : Fragment(R.layout.fr_main) {

    private val vm by navGraphViewModels<VM>(R.id.nav_graph)

    @SuppressLint("CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        next { nav(R.id.action_mainFragment_to_secondFragment) }
    }
}
