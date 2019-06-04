package pl.org.seva.myapplication.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.init.instance

class MainFragment : Fragment(R.layout.fr_main) {

    private val unit = Unit

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val str = instance<String>().provideDelegate(null, ::unit).value

        println("wiktor $str")

        val context = Job() + Dispatchers.Default

        val context1 = Dispatchers.Main + context
        val context2 = context + Dispatchers.Main


        println("wiktor ${context1[Dispatchers.Default.key]}")
        println("wiktor ${context2[Dispatchers.Default.key]}")


    }
}
