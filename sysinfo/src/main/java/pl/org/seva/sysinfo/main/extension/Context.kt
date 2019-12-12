package pl.org.seva.sysinfo.main.extension

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

val Context.prefs: SharedPreferences get() = PreferenceManager.getDefaultSharedPreferences(this)
