package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.act_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.org.seva.myapplication.R

class MainActivity: AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch {
            println("wiktor thread ${System.identityHashCode(Thread.currentThread())}")
            withContext(Dispatchers.IO) {
                println("wiktor thread ${System.identityHashCode(Thread.currentThread())}")
            }
            withContext(Dispatchers.Main) {
                println("wiktor thread ${System.identityHashCode(Thread.currentThread())}")
            }
        }
    }

}
