package pl.org.seva.sysinfo.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_main.*
import pl.org.seva.sysinfo.R
import pl.org.seva.sysinfo.main.extension.nav
import pl.org.seva.sysinfo.main.extension.invoke

class ThirdFragment : Fragment(R.layout.fr_main) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        next { nav(R.id.action_thirdFragment_to_secondFragment) }
    }
}
