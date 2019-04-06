package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.subjects.PublishSubject
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.inflate

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fr_main, container)

    @SuppressLint("SetTextI18n", "CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val s = PublishSubject.create<Unit>()
                .doOnSubscribe { println("wiktor subscribe") }
                .doOnDispose { println("wiktor dispose") }

        val d1 = s.subscribe()
        val d2 = s.subscribe()
        d1.dispose()
        val d3 = s.subscribe()
        d2.dispose()
        d3.dispose()
    }
}
