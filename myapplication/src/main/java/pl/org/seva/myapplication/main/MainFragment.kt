package pl.org.seva.myapplication.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.navGraphViewModels
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke

object A


class MainFragment : Fragment(R.layout.fr_main) {

    private val vm by navGraphViewModels<VM>(R.id.nav_graph)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (vm.ld to this) {
            println("wiktor result $it")
        }

        (MyLiveData() to this) {

        }
    }

    class MyLiveData : LiveData<Int>() {

        override fun onActive() {
            super.onActive()
            println("wiktor is active")
        }

        override fun onInactive() {
            super.onInactive()
            println("wiktor is inactive")
        }
    }
}
