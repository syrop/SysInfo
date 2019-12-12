package pl.org.seva.sysinfo.json

import android.os.Build
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import pl.org.seva.sysinfo.BuildConfig
import pl.org.seva.sysinfo.main.init.instance
import java.util.*

@JsonClass(generateAdapter = true)
data class SysInfo(
        val platform: String = "Android",
        val appId: String = BuildConfig.APPLICATION_ID,
        val appVersion: String = BuildConfig.VERSION_NAME,
        val appVersionCode: String = BuildConfig.VERSION_CODE.toString(),
        val distribution: String = if (BuildConfig.DEBUG) "debug" else "release",
        val hardware: String,
        val language: String = Locale.getDefault().toLanguageTag().substring(0, 2),
        val model: String = Build.MODEL,
        val os: String = "Android",
        val osVersion: String = Build.VERSION.RELEASE,
        val timeZone: String = TimeZone.getDefault().toZoneId().toString()) {

    private class Serializer {
        private val moshi by instance<Moshi>()

        fun serialize(sysInfo: SysInfo): String {
            val jsonAdapter = moshi.adapter(SysInfo::class.java)
            return jsonAdapter.toJson(sysInfo)
        }
    }

    override fun toString() = Serializer().serialize(this)
}
