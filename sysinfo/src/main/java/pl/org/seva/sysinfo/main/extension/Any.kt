package pl.org.seva.sysinfo.main.extension

import pl.org.seva.sysinfo.main.init.instance
import java.util.logging.Logger

val Any.log get() = instance<String, Logger>(arg = this::class.java.name)