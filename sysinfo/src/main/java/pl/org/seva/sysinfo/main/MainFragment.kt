package pl.org.seva.sysinfo.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import pl.org.seva.sysinfo.R
import com.squareup.moshi.Moshi
import pl.org.seva.sysinfo.json.SysInfo
import pl.org.seva.sysinfo.json.sysInfo
import pl.org.seva.sysinfo.main.init.instance

@ExperimentalCoroutinesApi
class MainFragment : Fragment(R.layout.fr_main) {

    private val moshi by instance<Moshi>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val jsonAdapter = moshi.adapter(SysInfo::class.java)

        val s = sysInfo {
        }

        println("wiktor ${jsonAdapter.toJson(s)}")
    }
}
