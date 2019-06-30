package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.navGraphViewModels
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Single
import io.reactivex.rxkotlin.Singles
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke

class MainFragment : Fragment(R.layout.fr_main) {

    private val vm by navGraphViewModels<VM>(R.id.nav_graph)

    @SuppressLint("CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var a = 10
        val f = { a++ }
        f()
        f()
        println("wiktor $a")

    }
}

class LastLocationPresenter(lastLocationView: (LatLng?) -> Unit) {

    init {
        GlobalScope.launch {
            lastLocationView(getLastLocation())
        }
    }

    private suspend fun getLastLocation(): LatLng? = null

}

