package pl.org.seva.sysinfo.json

import com.squareup.moshi.JsonClass

fun sysInfo(block: SysInfo.Builder.() -> Unit): SysInfo {
    return SysInfo.Builder().apply(block).build()
}

@JsonClass(generateAdapter = true)
data class SysInfo(val platform: String) {

    class Builder {
        var platform = "android"

        fun build() = SysInfo(platform)
    }
}
