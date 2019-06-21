package pl.org.seva.myapplication.main

import android.app.Application
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.conf.global
import pl.org.seva.myapplication.main.init.bootstrap
import pl.org.seva.myapplication.main.init.module

@Suppress("unused")
class MyApplication : Application() {

    init {
        Kodein.global.addImport(module)
    }

    override fun onCreate() {
        super.onCreate()
        GlobalScope.launch { bootstrap.boot() }
    }
}
