package pl.org.seva.myapplication.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke

class MainFragment : Fragment(R.layout.fr_main) {

    private val vm by navGraphViewModels<VM>(R.id.nav_graph)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (vm.ld to this) {
            println("wiktor result $0")
        }
    }
}
