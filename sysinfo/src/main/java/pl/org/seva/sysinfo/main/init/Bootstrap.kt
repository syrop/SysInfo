package pl.org.seva.sysinfo.main.init

import androidx.appcompat.app.AppCompatDelegate

val bootstrap by instance<Bootstrap>()

class Bootstrap {

    fun boot() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}
