package dev.caiofaustino.colekta

import android.app.Application
import logcat.AndroidLogcatLogger

class ColektaApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidLogcatLogger.installOnDebuggableApp(this)
    }
}