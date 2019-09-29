package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import pl.org.seva.myapplication.R
import java.time.Duration

class MainFragment : Fragment(R.layout.fr_main) {

    private val mux = Mutex()

    private fun synchronizeThis(callback: () -> Unit) {
        println("wiktor begin to sleep")
        Thread.sleep(Duration.ofSeconds(2).toMillis())
        println("wiktor slept")
        callback()
    }


    private suspend fun wrappedSynchronizeThis() = withContext(Dispatchers.IO) {
        suspendCancellableCoroutine<Unit> { continuation ->
            synchronizeThis {
                continuation.resumeWith(Result.success(Unit))
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            mux.withLock {
                wrappedSynchronizeThis()
            }
        }
        println("wiktor finished onViewCreated")
    }

    override fun onResume() {
        super.onResume()
        println("wiktor on resume")
        lifecycleScope.launch {
            mux.withLock {
                println("wiktor in the synchronized block in onResume()")
            }
        }
        println("wiktor finished onResume()")
    }
}
