package pl.org.seva.myapplication.main.extension

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import pl.org.seva.myapplication.main.init.KodeinModuleBuilder

val Context.prefs: SharedPreferences get() = PreferenceManager.getDefaultSharedPreferences(this)

val Context.module get() = KodeinModuleBuilder(this).build()
