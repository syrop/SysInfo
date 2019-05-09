package pl.org.seva.myapplication.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import kotlinx.android.synthetic.main.fr_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import pl.org.seva.myapplication.R
import java.time.LocalTime

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val p1 = context!!.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val p2 = activity!!.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        println("wiktor equals ${p1 === p2}")

    }

    companion object {
        const val PREFS_NAME = "prefs"
    }
}
