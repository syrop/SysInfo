package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.inflate

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fr_main, container)

    private val vm by lazy { ViewModelProviders.of(this).get(VM::class.java) }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Wszystko().apply {
            nieWiew()
            nieWiemPoCo()
        }
    }
}
