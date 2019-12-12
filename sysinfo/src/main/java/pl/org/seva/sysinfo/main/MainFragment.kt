package pl.org.seva.sysinfo.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.fragment.app.Fragment
import com.squareup.moshi.Moshi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import pl.org.seva.sysinfo.R
import pl.org.seva.sysinfo.json.SysInfo
import pl.org.seva.sysinfo.main.init.instance


@ExperimentalCoroutinesApi
class MainFragment : Fragment(R.layout.fr_main) {

    private val moshi by instance<Moshi>()

    @SuppressLint("HardwareIds")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sysInfo = SysInfo(hardware = Settings.Secure.getString(
                    requireContext().contentResolver,
                    Settings.Secure.ANDROID_ID))
        println("wiktor $sysInfo")
    }
}
